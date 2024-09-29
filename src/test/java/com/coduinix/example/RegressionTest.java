package com.coduinix.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Approval test for 'the whole' application.
 */
public class RegressionTest {

    @Test
    public void shouldCalculateTotals() {
        String actual = captureStdOut(() -> {
            final var fileName = "src/test/resources/transactions.csv";
            Launcher.main(new String[]{fileName});
        });
        String expected = """
                Total credit : €     234,56
                Total debit  : €      87,65
                Balance      : €     146,91
                """;
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
