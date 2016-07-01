package com.epam.notebook.provider;


import com.epam.notebook.entity.Note;
import com.epam.notebook.entity.NoteBook;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by ivanpryshchepau on 6/29/16.
 */
public class NoteBookProvider {

    private static NoteBookProvider instance;

    private ArrayList<NoteBook> nbList = new ArrayList<NoteBook>();

    public void setNbList(ArrayList<NoteBook> nbList) {
        this.nbList = nbList;
    }

    public NoteBookProvider() {
    }

    public static NoteBookProvider getInstance(){
        if (instance == null) {
            instance = new NoteBookProvider();
        }
        return instance;
    }

    public StringBuilder writeNoteBooks() {
        StringBuilder infoAll = new StringBuilder();

        for (NoteBook noteBook : instance.nbList) {
            infoAll.append(noteBook.getTitle() + "\t\t" + noteBook.getDate() + "\n");
        }

        return infoAll;
    }

    public NoteBook addNoteBook(String title) {
        for (NoteBook nb : nbList) {
            if (nb.getTitle().equals(title)) {
                System.out.println("This name is busy");
                return null;
            }
        }
        NoteBook noteBook = new NoteBook();
        noteBook.setTitle(title);
        noteBook.setDate(Calendar.getInstance().getTime());
        nbList.add(noteBook);
        return noteBook;
    }

    public NoteBook openNoteBook(String title) {
        for (NoteBook nb : nbList) {
            if (nb.getTitle().equals(title)) {
                return nb;
            }
        }
        System.out.println("Not found");
        return null;
    }

    public void deleteNoteBook(String title) {
        for (NoteBook nb : nbList) {
            if (nb.getTitle().equals(title)) {
                nbList.remove(nbList.indexOf(nb));
            }
        }
        //System.out.println("Not found");
    }

    public Note addNote(String title, String noteStr, NoteBook noteBook) {
        for (Note note : noteBook.getNoteList()) {
            if (note.getTitle().equals(title)) {
                System.out.println("This name is busy");
                return null;
            }
        }
        Note note = new Note();
        note.setTitle(title);
        note.setNote(noteStr);
        note.setDate(Calendar.getInstance().getTime());
        noteBook.addToList(note);
        return note;
    }

    public Note openNote(String title, String noteStr, NoteBook noteBook) {
        for (Note note : noteBook.getNoteList()) {
            if (note.getTitle().equals(title)) {
                note.setNote(noteStr);
                note.setDate(Calendar.getInstance().getTime());
                noteBook.setDate(Calendar.getInstance().getTime());
                return note;
            }
        }
        return null;
    }

    public void deleteNote(String title, NoteBook noteBook) {
        for (Note note : noteBook.getNoteList()) {
            if (note.getTitle().equals(title)) {
                noteBook.getNoteList().remove(noteBook.getNoteList().indexOf(note));
            }
        }
        //System.out.println("Not found");
    }
}
