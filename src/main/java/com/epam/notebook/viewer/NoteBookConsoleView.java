package com.epam.notebook.viewer;

import com.epam.notebook.entity.Note;
import com.epam.notebook.entity.NoteBook;
import com.epam.notebook.provider.DataProvider;
import com.epam.notebook.provider.NoteBookProvider;

import java.util.Scanner;

/**
 * Created by ivanpryshchepau on 6/29/16.
 */
public class NoteBookConsoleView {

    static NoteBookProvider provider = NoteBookProvider.getInstance();

    static Scanner sc = new Scanner(System.in);

    static String command;

    static NoteBook currNB;

    static DataProvider dataProvider = new DataProvider();

    public static void mainMenu() {
        System.out.println("Welcome to NoteBook 1.0");
        dataProvider.objFromJson();
        noteBookMenu();
    }

    public static void noteBookMenu() {
        System.out.println("---------------------------------------");
        System.out.println("NoteBooks:");
        System.out.println("Title\tLast edit");
        System.out.println(provider.writeNoteBooks());
        System.out.println("Write 'new' to create notebook");
        System.out.println("Write 'open' to open notebook");
        System.out.println("Write 'delete' to delete notebook");
        System.out.println("Write 'exit' to close application");
        command = sc.next();
        parseNoteBookCommand(command);
    }

    public static void noteMenu() {
        System.out.println("---------------------------------------");
        System.out.println("Notes:");
        System.out.println("Title\tNote\t\tLast edit");
        System.out.println(print(currNB));
        System.out.println("Write 'new' to create note");
        System.out.println("Write 'edit' to edit note");
        System.out.println("Write 'delete' to delete note");
        System.out.println("Write 'back' to delete note");
        command = sc.next();
        parseNoteCommand(command);
    }

    public static void parseNoteBookCommand(String command) {
        switch (command) {
            case "new": {
                System.out.println("Write title: ");
                command = sc.next();
                provider.addNoteBook(command);
                noteBookMenu();
                break;
            }
            case "open": {
                System.out.println("Write title: ");
                command = sc.next();
                currNB = provider.openNoteBook(command);
                if (currNB != null){
                    noteMenu();
                } else {
                    noteBookMenu();
                }
                break;
            }
            case "delete": {System.out.println("Write title: ");
                command = sc.next();
                provider.deleteNoteBook(command);
                noteBookMenu();
                break;
            }
            case "exit": {
                dataProvider.jsonForFile();
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Incorrect command");
                noteBookMenu();
                break;
            }
        }
    }

    public static void parseNoteCommand(String command) {
        switch (command) {
            case "new": {
                System.out.println("Write title: ");
                command = sc.next();
                System.out.println("Write note: ");
                String note = sc.next();
                provider.addNote(command, note, currNB);
                noteMenu();
                break;
            }
            case "edit": {
                System.out.println("Write title: ");
                command = sc.next();
                System.out.println("Write note: ");
                String note = sc.next();
                provider.editNote(command, note, currNB);
                noteMenu();
                break;
            }
            case "delete": {
                System.out.println("Write title: ");
                command = sc.next();
                provider.deleteNote(command, currNB);
                noteMenu();
                break;
            }
            case "back": {
                noteBookMenu();
                break;
            }
            default: {
                System.out.println("Incorrect command");
                noteMenu();
                break;
            }
        }
    }

    public static StringBuilder print(NoteBook noteBook){
        StringBuilder infoAll = new StringBuilder();

        for (Note note : noteBook.getNoteList()) {
            infoAll.append(note.getTitle() + "\t\t" + note.getNote() + "\t\t" + note.getDate() + "\n");
        }

        return infoAll;
    }

    public static StringBuilder print(String... titles){
        StringBuilder infoAll = new StringBuilder();

        for (String title : titles) {
            for (Note note : currNB.getNoteList()) {
                if (note.getTitle().equals(title)) {
                    infoAll.append(note.getTitle() + "\t\t" + note.getNote() + "\t\t" + note.getDate() + "\n");
                }
            }
        }
        return infoAll;
    }
}
