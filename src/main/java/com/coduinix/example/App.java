package com.coduinix.example;

public class App {
    private TextFormatter textFormatter;

    public void run(final TransactionStore transactionStore) {
        textFormatter = new TextFormatter(transactionStore);
        final var formattedSummary = textFormatter.formatSummary();
        System.out.println(formattedSummary);
    }

}
