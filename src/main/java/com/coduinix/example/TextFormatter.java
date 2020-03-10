package com.coduinix.example;

import java.util.Locale;

public class TextFormatter {
    private final TransactionStore transactionStore;

    public TextFormatter() {
        transactionStore = new CsvTransactionStore(App.getCsvFile());
    }

    public String formatSummary() {
        Summary summary = transactionStore.loadSummary();
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
