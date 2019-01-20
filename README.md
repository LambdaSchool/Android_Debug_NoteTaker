# Android_Debug_NoteTaker

## Note

I noted and fixed 8 bugs total.  I denoted them in code using a TODO tag for each in a comment next to it to make it easy to find by clicking the TODO list tab or by clicking in the menus: View> Tool Windows> TODO.  I have also listed them below.

## Debug items found.

1. On line 27	of EditActivity.java:       Change hardcoded string to be the EDIT_NOTE_KEY constant to match the value put into the intent.
2. On line 133	of MainActivity.java:       Add missing opening brace.
3. On line 32	of NetworkAdapter.java:     Add missing line to set the request method on the HttpURLConnection.
4. On line 109	of Note.java:               Add missing ; to the end of the line.
5. On line 23	of NoteListAdapter.java:    Change reference ID from R.id.showTitle to R.id.note_element_title to match the layout file.
6. On line 42	of NoteRepository.java:     Comment out existing addNote method and rewrite accommodate an already existing note.
7. On line 8 	of NotesDbHelper.java:      Change database version from 0 to 1.
8. On line 15	of NotesFirebaseDao.java:   Add entire line to define USER_ID constant value.