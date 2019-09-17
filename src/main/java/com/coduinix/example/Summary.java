package com.coduinix.example;

import java.math.BigDecimal;

public class Summary {
    private BigDecimal balance;
    private BigDecimal credit;
    private BigDecimal debit;

    public Summary(BigDecimal balance, BigDecimal credit, BigDecimal debit) {
        this.balance = balance;
        this.credit = credit;
        this.debit = debit;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public BigDecimal getDebit() {
        return debit;
    }
}
