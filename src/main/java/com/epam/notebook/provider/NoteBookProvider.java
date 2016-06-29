package com.epam.notebook.provider;

/**
 * Created by ivanpryshchepau on 6/29/16.
 */
public class NoteBookProvider {

    private static final NoteBookProvider instance = new NoteBookProvider();

    private NoteBookProvider() {
    }

    public static NoteBookProvider getInstance(){
        return instance;
    }
}
