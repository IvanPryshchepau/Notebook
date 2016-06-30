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
            infoAll.append(noteBook.getTitle() + "\t" + noteBook.getDate() + "\n");
        }

        return infoAll;
    }

    public void add(String title) {
        NoteBook noteBook = new NoteBook();
        noteBook.setTitle(title);
        noteBook.setDate(Calendar.getInstance().getTime());
        nbList.add(noteBook);
    }

    public NoteBook open(String title) {
        for (NoteBook nb : nbList) {
            if (nb.getTitle().equals(title)) {
                return nb;
            }
        }
        System.out.println("Not found");
        return null;
    }

    public void delete(String title) {
        for (NoteBook nb : nbList) {
            if (nb.getTitle().equals(title)) {
                nbList.remove(nbList.indexOf(nb));
            }
        }
        System.out.println("Not found");
    }
}
