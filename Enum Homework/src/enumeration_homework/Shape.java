package enumeration_homework;

public enum Shape implements Drawable{
    CIRCLE{
        @Override
        public void draw(){
            System.out.println("Drawing a CIRCLE");
        }
    },
    SQUARE{
        @Override
        public void draw(){
            System.out.println("Drawing a SQUARE");
        }
    },
    TRIANGLE{
        @Override
        public void draw(){
            System.out.println("Drawing a TRIANGLE");
        }
    };
}
