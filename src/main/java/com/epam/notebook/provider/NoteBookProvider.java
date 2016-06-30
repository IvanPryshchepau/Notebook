package com.epam.notebook.provider;


/**
 * Created by ivanpryshchepau on 6/29/16.
 */
public class NoteBookProvider {

    private static NoteBookProvider instance;

    public NoteBookProvider() {
    }

    public static NoteBookProvider getInstance(){
        if (instance == null) {
            instance = new NoteBookProvider();
        }
        return instance;
    }


}
