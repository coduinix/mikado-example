package com.coduinix.example;

import java.io.File;

public class App {
    private static File csvFile;
    private TextFormatter textFormatter;

    public void run() {
        textFormatter = new TextFormatter();
        final var formattedSummary = textFormatter.formatSummary();
        System.out.println(formattedSummary);
    }

    public static void setCsvFile(File file) {
        csvFile = file;
    }

    public static File getCsvFile() {
        return csvFile;
    }

}
