package com.coduinix.example;

import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class CsvTransactionStore implements TransactionStore {
    private final File csvFile;

    public CsvTransactionStore(File csvFile) {
        this.csvFile = csvFile;
    }

    @Override
    public Summary loadSummary() {
        try (var in = new FileInputStream(csvFile);
             var reader = new BufferedReader(new InputStreamReader(in));
             var csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build()
        ) {
            BigDecimal credit = BigDecimal.ZERO;
            BigDecimal debit = BigDecimal.ZERO;
            Locale ingNL = new Locale("nl", "NL");
            DecimalFormat nf = (DecimalFormat) NumberFormat.getInstance(ingNL);
            nf.setParseBigDecimal(true);
            for (String[] cs : csvReader.readAll()) {
                BigDecimal amount = (BigDecimal) nf.parse(cs[6]);
                if (cs[5].equals("Credit")) credit = credit.add(amount);
                else debit = debit.add(amount);
            }
            return new Summary(BigDecimal.ZERO.add(credit).subtract(debit), credit, debit);
        } catch (IOException | ParseException | CsvException e) {
            throw new RuntimeException("Error while reading transactions", e);
        }
    }
}
