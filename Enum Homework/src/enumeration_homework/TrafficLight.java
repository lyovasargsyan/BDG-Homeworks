package enumeration_homework;

public enum TrafficLight {
    RED{
        @Override
        public TrafficLight getNextLight(){
            return GREEN;
        }
    },
    YELLOW{
        @Override
        public  TrafficLight getNextLight(){
            return RED;
        }
    },
    GREEN{
        @Override
        public TrafficLight getNextLight(){
            return YELLOW;
        }
    };

    public abstract TrafficLight getNextLight();
}
