package enumeration_homework;

public enum Currency {
    USD{
        @Override
        public String toString(){
            return "USD - United States Dollar";
        }
    },
    EUR{
        @Override
        public String toString(){
            return "EUR - Euro";
        }
    },
    JPY{
        @Override
        public String toString(){
            return "JPY - Japanese Yen";
        }
    };

    public abstract String toString();
}
