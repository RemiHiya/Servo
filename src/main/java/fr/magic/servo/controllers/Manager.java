package fr.magic.servo.controllers;

import com.google.gson.Gson;
import fr.magic.servo.Main;

import java.io.File;

public class Manager {

    private static final File DATA = Main.getDataFile();
    private static final Gson gson = new Gson();
}
