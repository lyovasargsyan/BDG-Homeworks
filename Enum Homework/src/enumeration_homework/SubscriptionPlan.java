package enumeration_homework;

public enum SubscriptionPlan {
    FREE(0),
    BASIC(5),
    PREMIUM(20),
    ENTERPRISE(200);

    public double price;

    SubscriptionPlan(double price) {
        this.price = price;
    }
}
