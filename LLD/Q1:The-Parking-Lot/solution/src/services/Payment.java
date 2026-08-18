package services;

import java.util.UUID;

public abstract class Payment {
    protected final String transactionId;
    protected double amount;

    public Payment(double amount){
        this.transactionId = "TXN - " + UUID.randomUUID().toString().substring(0,8).toUpperCase();
        this.amount = amount;
    }
    public abstract boolean process();
    public String getTransactionId() { return transactionId; }
}
