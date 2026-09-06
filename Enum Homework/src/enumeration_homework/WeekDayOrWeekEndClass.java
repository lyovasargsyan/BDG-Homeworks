package enumeration_homework;

public class WeekDayOrWeekEndClass {
    public static boolean isWeekday(Day day){
        return day != Day.SUNDAY && day != Day.SATURDAY;
    }
    public static void main(String[] args) {
        Day day = Day.SUNDAY;
        if(isWeekday(day)){
            System.out.println("Weekday");
        }
        else{
            System.out.println("Weekend");
        }
    }
}
