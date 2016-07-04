package com.epam.notebook.provider;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

/**
 * Created by ivanpryshchepau on 7/4/16.
 */
public class DataProvider {

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void jsonForFile() {
        try (Writer writer = new FileWriter("Output.json")) {
            gson.toJson(NoteBookProvider.getInstance(), NoteBookProvider.class, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void objFromJson() {
        try (Reader reader = new FileReader("Output.json")) {
            NoteBookProvider.getInstance().setNbList(gson.fromJson(reader, NoteBookProvider.class).getNbList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
