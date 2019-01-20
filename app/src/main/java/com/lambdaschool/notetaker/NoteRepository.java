package com.lambdaschool.notetaker;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class NoteRepository {
//    private ArrayList<Note> notes;
        MutableLiveData<ArrayList<Note>> liveDataList;

    /*public NoteRepository() {
        this.notes = new ArrayList<>();
    }*/

    public MutableLiveData<ArrayList<Note>> getNotes(Context context) {
        liveDataList = new MutableLiveData<>();
        NotesDbDao.initializeInstance(context);
        // retrieve notes from cache
        liveDataList.setValue(getNotesFromCache());
        // retrieve notes from online DB
        new Thread(new Runnable() {
            @Override
            public void run() {
                final ArrayList<Note> notes = NotesFirebaseDao.getNotes();

                final ArrayList<Note> updatedNotes = NotesDbDao.updateCache(notes);

                liveDataList.postValue(updatedNotes);
            }
        }).start();
        return liveDataList;
    }

    private ArrayList<Note> getNotesFromCache() {
        return NotesDbDao.readAllNotes();
    }

/*    public void addNote(final Note note) {//TODO change this method to method below to accommodate an already existing note.
        new Thread(new Runnable() {
            @Override
            public void run() {
                String newId = NotesFirebaseDao.createNote(note);
                note.setId(newId);
                NotesDbDao.createNote(note);
                liveDataList.postValue(getNotesFromCache());
            }
        }).start();
//        return SharedPrefsDao.getAllNotes();
    }*/


    public void addNote(final Note note) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (note.getId().equals(Note.NO_ID)) {
                    String newId = NotesFirebaseDao.createNote(note);
                    note.setId(newId);
                    NotesDbDao.createNote(note);
                } else {
                    NotesFirebaseDao.updateNote(note.getId(), note);
                    NotesDbDao.updateNote(note);
                }
                liveDataList.postValue(getNotesFromCache());
            }
        }).start();
    }

    public void deleteNote(final Note note) { //TODO Bonus: add code for deleting note.
        new Thread(new Runnable() {
            @Override
            public void run() {
                NotesFirebaseDao.deleteNote(note.getId());
                NotesDbDao.deleteNote(note);
                liveDataList.postValue(getNotesFromCache());
            }
        }).start();
    }

}
