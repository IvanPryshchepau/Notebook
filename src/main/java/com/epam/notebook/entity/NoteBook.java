package com.epam.notebook.entity;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by ivanpryshchepau on 6/29/16.
 */
public class NoteBook {

    private String title;
    private ArrayList<Note> noteList = new ArrayList<Note>();
    private Date date;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(ArrayList<Note> noteList) {
        this.noteList = noteList;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void addToList(Note note) {
        noteList.add(note);
    }

    @Override
    public int hashCode() {
        return title.hashCode() + noteList.hashCode() + date.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        NoteBook noteBook = (NoteBook) obj;
        if (null == title || null == date || null == noteList) {
            return (title == noteBook.title && date == noteBook.date && noteList == noteBook.noteList);
        } else {
            if (!title.equals(noteBook.title) || (!date.equals(noteBook.date))) {
                return false;
            }
        }
        if (!noteList.equals(noteBook.noteList)) {
            return false;
        }
        return true;

    }

    @Override
    public String toString() {
        return title + "@" + noteList.toString() + "^" + date;
    }
}
