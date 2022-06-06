package com.coduinix.example;

import java.math.BigDecimal;

public record Summary(BigDecimal balance, BigDecimal credit, BigDecimal debit) {
}
