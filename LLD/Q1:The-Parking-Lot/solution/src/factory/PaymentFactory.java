package factory;

import enums.PaymentType;
import services.CardPayment;
import services.CashPayment;
import services.Payment;
import services.UpiPayment;

public class PaymentFactory {
    public static Payment createPayment(PaymentType paymentType, double amount){
        switch (paymentType){
            case UPI -> {
                return new UpiPayment(amount);
            }
            case CARD -> {
                return new CardPayment(amount);
            }
            case CASH -> {
                return new CashPayment(amount);
            }
            default -> {
                throw new IllegalArgumentException("Unknown payment type: " + paymentType);
            }
        }
    }
}
