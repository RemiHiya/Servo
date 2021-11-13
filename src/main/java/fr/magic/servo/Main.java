package fr.magic.servo;

import fr.magic.servo.utils.Constants;
import fr.magic.servo.utils.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class Main {

    private static final Logger LOGGER = new Logger("Servo");
    private static final File DIR = createFile("");
    private static final File DATAFILE = createFile("data.json");

    public static void main(String[] args) {
        makeNewFile(DIR, true);
        makeNewFile(DATAFILE, false);
    }


    private void init(String... args) {

    }
    /*
    private static boolean loadJavaFx() {
        if(isJavaFxLoaded()) {
            LOGGER.log("JavaFx  has been loaded.");
            return true;
        }

        File jfxrt = new File(DIR);
    }*/

    private static boolean isJavaFxLoaded() {
        try {
            Main.class.getClassLoader().loadClass("javafx.embed.swing.JFXPanel");
            return true;
        } catch (ClassNotFoundException e) {
            LOGGER.warn(e.getMessage());
            return false;
        }
    }

    private static File createFile(String path) {
        String os = System.getProperty("os.name").toLowerCase(Locale.ROOT);
        String s = File.separator;
        String win = System.getProperty("user.home") + s + "AppData" + s + "Roaming" + s + ".";
        String mac = System.getProperty("user.home") + s + "Library" + s + "Application Support" + s;
        String lin = System.getProperty("user.home") + s + ".";
        try {
            if(os.contains("win")) {
                return new File(win + Constants.NAME + (path == "" ? "" : s + path));
            } else if(os.contains("mac")){
                return new File(mac + Constants.NAME + (path == "" ? "" : s + path));
            } else {
                return new File(lin + Constants.NAME + (path == "" ? "" : s + path));
            }
        } catch(Exception e) {
            System.out.println(e + " Impossible");
            return null;
        }
    }

    private static void makeNewFile(File file, boolean folder) {
        if(folder) {
            if(file.mkdir()) {
                LOGGER.log("Directory " + file.getName() + " successfully created at " + file.getParent() + ".");
            } else {
                LOGGER.warn("Directory " + file.getName() + " already exists at " + file.getParent() + ".");
            }
        } else {
            try {
                if(file.createNewFile()) {
                    LOGGER.log("File " + file.getName() + " successfully created at " + file.getParent() + ".");
                } else {
                    LOGGER.warn("File " + file.getName() + " already exists at " + file.getParent() + ".");
                }
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
            }
        }
    }

    public static File getDir() {
        return DIR;
    }

    public static File getDataFile() {
        return DATAFILE;
    }

    public static Logger getLogger() {
        return LOGGER;
    }

}
