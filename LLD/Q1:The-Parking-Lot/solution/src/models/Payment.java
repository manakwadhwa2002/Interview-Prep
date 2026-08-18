package models;

import java.util.concurrent.atomic.AtomicInteger;

public class Payment {
    private AtomicInteger transactionId;
    private int amount;

    public Payment(AtomicInteger transactionId, int amount) {
        this.transactionId = transactionId;
        this.amount = amount;
    }
}
