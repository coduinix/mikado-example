package com.coduinix.example;

import java.util.Locale;

public class TextFormatter {
    private final CsvTransactionStore csvTransactionStore;

    public TextFormatter() {
        csvTransactionStore = new CsvTransactionStore();
        csvTransactionStore.setSource(App.getCsvFile());
    }

    public String formatSummary() {
        Summary summary = csvTransactionStore.loadSummary();
        return String.format(new Locale("nl", "NL"), "" +
                "Total credit : € %,10.2f\n" +
                "Total debit  : € %,10.2f\n" +
                "Balance      : € %,10.2f",
                summary.getCredit(),
                summary.getDebit(),
                summary.getBalance()
        );
    }
}
