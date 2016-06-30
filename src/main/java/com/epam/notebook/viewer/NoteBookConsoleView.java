package com.epam.notebook.viewer;

import com.epam.notebook.provider.NoteBookProvider;

/**
 * Created by ivanpryshchepau on 6/29/16.
 */
public class NoteBookConsoleView {

    static NoteBookProvider provider = NoteBookProvider.getInstance();

    public static void mainMenu() {
        System.out.println("Welcome to NoteBook 1.0");
        System.out.println("NoteBooks:");
        System.out.println("Title\tLast edit");
        System.out.println(provider.writeNoteBooks());
        System.out.println("Write 'new [title]' to create notebook");
        System.out.println("Write 'open [title]' to open notebook");
        System.out.println("Write 'delete [title]' to delete notebook");
    }



}
