package com.epam.notebook.entity;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.testng.Assert.*;

/**
 * Created by ivanpryshchepau on 7/4/16.
 */
public class NoteBookTest {
    @Test
    public void testHashCode() throws Exception {

    }

    @Test
    public void testEquals() throws Exception {
        NoteBook n1 = new NoteBook();
        ArrayList<Note> arrayList = new ArrayList<>();
        arrayList.add(new Note());
        Date date = Calendar.getInstance().getTime();
        n1.setTitle("1");
        n1.setNoteList(arrayList);
        n1.setDate(date);
        NoteBook n2 = new NoteBook();
        n2.setTitle("1");
        n2.setNoteList(arrayList);
        n2.setDate(date);
        assertTrue(n1.equals(n2));
    }

    @Test
    public void testToString() throws Exception {
        NoteBook n1 = new NoteBook();
        ArrayList<Note> arrayList = new ArrayList<>();
        arrayList.add(new Note());
        Date date = Calendar.getInstance().getTime();
        n1.setTitle("1");
        n1.setNoteList(arrayList);
        n1.setDate(date);
        String str = "1@[null@null^null]^" + date;
        assertEquals(n1.toString(), str);
    }

}