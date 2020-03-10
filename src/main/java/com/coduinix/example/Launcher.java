package com.coduinix.example;

import java.io.File;

public class Launcher {
    public static void main(String[] args) {
        try {
            var file = new File(args[0]);
            App app = new App();
            app.run(new CsvTransactionStore(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
