# Android_Debug_NoteTaker

## Introduction

This goal of this project is to debug a Note Taker project. As this is a project specifically intended to help you practice your debugging skills and using the resources available to you, refrain from asking for help unless absolutely necessary.

## Instructions

Please fork and clone this repository. It contains the broken project that you should debug. As this is a project that you have worked on previously, do not use your own completed version of this project as you will gain nothing (in the long term) from referencing it.

As a recap, the project when working properly should:

- Allow the user to create notes that are saved to a Firebase Database and an on-device persistent store using an SQL database
- The device's persistent store is synchronized with the Firebase Database. (When a journal entry is saved to the device's persistent store it gets sent to Firebase, and vice-versa.


Bugs:
1. for each loop in the method populateSampleData in main activity (line 133 for me) was missing an opening bracket.
2. A json.put call was missing a semi colon in the Note class (line 109 for me).
3. The USER_ID constant was missing in the NotesFirabaseDao class.
4. Database version was set to 0 in the NotesDbHelper, needs to be 1 or greater.
5. noteTitle in the NoteListAdapter ViewHolder was set to a view that doesnt exist (line 23 for me).
6. EditActivity used the wrong key to get the note data sent from the intent (line 27 for me).
7. The connection in the network adapter never gets the type set, so when you post it would think it was a get (line 32 for me).
