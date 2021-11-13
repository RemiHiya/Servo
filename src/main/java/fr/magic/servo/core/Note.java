package fr.magic.servo.core;

import java.io.File;

public class Note {

    private int id;
    private String title;
    private File file;
    private int[] parents;

    public Note(int id, String title, File file, int[] parents) {
        this.id = id;
        this.title = title;
        this.file = file;
        this.parents = parents;
    }

    public Note(int id, String title, File file) {
        this(id, title, file, null);
    }

    public Note(int id, String title) {
        this(id, title, null, null);
    }

    public Note(int id, String title, int[] parents) {
        this(id, title, null, parents);
    }

}
