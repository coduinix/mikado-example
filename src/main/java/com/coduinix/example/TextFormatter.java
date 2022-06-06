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
        return String.format(new Locale("nl", "NL"), """
                        Total credit : € %,10.2f
                        Total debit  : € %,10.2f
                        Balance      : € %,10.2f""",
                summary.credit(),
                summary.debit(),
                summary.balance()
        );
    }
}
