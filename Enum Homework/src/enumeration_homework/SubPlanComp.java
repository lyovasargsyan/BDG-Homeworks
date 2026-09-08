package enumeration_homework;

public class SubPlanComp {
    public SubscriptionPlan tierOne(SubscriptionPlan plan1, SubscriptionPlan plan2){
        if(plan1.price > plan2.price){
            return plan1;
        }
        return plan2;
    }
    public static void main(String[] args){
        SubscriptionPlan subscriptionPlan = SubscriptionPlan.FREE;
        switch (subscriptionPlan){
            case FREE -> {
                System.out.println("basic/free usage");}
            case ENTERPRISE -> {
                System.out.println("advanced scurity, many users");
            }
            case PREMIUM -> {
                System.out.println("advanced individual or small business usage");
            }
            case BASIC -> {
                System.out.println("Individual users with more features");
            }
        }
    }
}
