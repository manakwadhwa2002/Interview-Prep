package services;

public class UpiPayment extends Payment{
    public UpiPayment(double amount){ super(amount);}

    @Override
    public boolean process(){
        System.out.printf("[UPI] Processed payment of $%.2f via transaction: %s\n", amount, transactionId);
        return true;
    }
}
