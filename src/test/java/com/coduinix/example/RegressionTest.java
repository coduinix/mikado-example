package com.coduinix.example;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for 'the whole' application.
 */
public class RegressionTest {

    @Test
    public void shouldCalculateTotals() throws Exception {
        String actual = captureStdOut(() -> {
            final var fileName = "src/test/resources/transactions.csv";
            Launcher.main(new String[]{fileName});
        });
        String expected = "" +
                "Total credit : €     234,56\n" +
                "Total debit  : €      87,65\n" +
                "Balance      : €     146,91\n";
        assertEquals(expected, actual);
    }

    private String captureStdOut(Runnable runnable) {
        final PrintStream originalOut = System.out;
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        try {
            System.setOut(new PrintStream(outContent));
            runnable.run();
        } finally {
            System.setOut(originalOut);

        }
        return outContent.toString();
    }

}
