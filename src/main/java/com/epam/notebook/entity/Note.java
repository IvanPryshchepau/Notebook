package com.epam.notebook.entity;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by ivanpryshchepau on 6/29/16.
 */
public class Note {

    private String title;
    private String note;
    private Date date;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = Calendar.getInstance().getTime();
    }

    @Override
    public int hashCode() {
        return ((null == title || null == note || null == date) ? 0 :
                title.hashCode() + note.hashCode() + date.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (null == obj) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Note noteobj = (Note) obj;

        if (null == title) {
            return (title == noteobj.title);
        } else {
            if (!title.equals(noteobj.title)) {
                return false;
            }
        }

        if (null == note) {
            return (note == noteobj.note);
        } else {
            if (!note.equals(noteobj.note)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        return title + "@" + note + "^" + date;
    }
}
