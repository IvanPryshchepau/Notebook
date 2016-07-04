package com.epam.notebook.entity;

import java.util.Calendar;
import java.util.Date;

import static org.testng.Assert.*;

/**
 * Created by ivanpryshchepau on 7/4/16.
 */
public class NoteTest {
    @org.testng.annotations.Test
    public void testHashCode() throws Exception {
        //!!!
    }

    @org.testng.annotations.Test
    public void testEquals() throws Exception {
        Date date = Calendar.getInstance().getTime();
        Note n1 = new Note();
        n1.setTitle("1");
        n1.setNote("qwer");
        n1.setDate(date);
        Note n2 = new Note();
        n2.setTitle("1");
        n2.setNote("qwer");
        n2.setDate(date);
        assertTrue(n1.equals(n2));
    }

    @org.testng.annotations.Test
    public void testToString() throws Exception {
        Date date = Calendar.getInstance().getTime();
        Note n1 = new Note();
        n1.setTitle("1");
        n1.setNote("qwer");
        n1.setDate(date);
        String str = "1@qwer^" + date;
        assertEquals(n1.toString(), str);
    }

}