package com.epam.notebook.viewer;

import com.epam.notebook.provider.NoteBookProvider;

import java.util.Scanner;

/**
 * Created by ivanpryshchepau on 6/29/16.
 */
public class NoteBookConsoleView {

    static NoteBookProvider provider = NoteBookProvider.getInstance();

    static Scanner sc = new Scanner(System.in);

    static String command;

    public static void mainMenu() {
        System.out.println("Welcome to NoteBook 1.0");
        noteBookMenu();
    }

    public static void noteBookMenu() {
        System.out.println("NoteBooks:");
        System.out.println("Title\tLast edit");
        System.out.println(provider.writeNoteBooks());
        System.out.println("Write 'new [title]' to create notebook");
        System.out.println("Write 'open [title]' to open notebook");
        System.out.println("Write 'delete [title]' to delete notebook");
        command = sc.next();
        parseNoteBookCommand(command);
    }

    public static void parseNoteBookCommand(String command) {
        String[] commands = command.split("\\s+");
        System.out.println(commands[0]);
        switch (commands[0]) {
            case "new": {
                provider.addNoteBook(commands[1]);
                noteBookMenu();
                break;
            }
            case "open": {
                provider.openNoteBook(commands[1]);
                break;
            }
            case "delete": {
                provider.deleteNoteBook(commands[1]);
                noteBookMenu();
                break;
            }
            default: {
                System.out.println("Incorrect command");
                noteBookMenu();
                break;
            }
        }
    }



}
