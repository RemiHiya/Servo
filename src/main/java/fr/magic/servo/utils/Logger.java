package fr.magic.servo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    private String name;

    public Logger(String name){
        this.name = name;
    }

    public void log(String message, Object... format){
        colorMessage(ConsoleColor.GREEN_LITTLE_BLUE, prefix() + "[INFO] " + String.format(message, format));
    }

    public void warn(String message, Object... format){
        colorMessage(ConsoleColor.YELLOW, prefix() + "[WARN] " + String.format(message, format));
    }

    public void error(String message, Object... format){
        colorMessage(ConsoleColor.RED, prefix() + "[ERROR] " + String.format(message, format));
    }

    public String prefix(){
        StringBuilder builder = new StringBuilder();
        builder.append("[").append(name).append("]").append(" [");
        String format = "dd/MM/yyyy HH:mm:ss";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        String date = dateFormat.format(new Date(System.currentTimeMillis()));
        builder.append(date).append("] ");
        return builder.toString();
    }

    public String getName() {
        return name;
    }

    public void colorMessage(ConsoleColor color, String message){
        System.out.println(color + message + ConsoleColor.RESET);
    }
}
