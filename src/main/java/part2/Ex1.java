package part2;

public class Ex1 {

    private static final String[] DAYS = {
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday",
            "Saturday",
            "Sunday"
    };

    public static void main(String... args) throws Exception{
        Ex1 ex1 = new Ex1();
        for (int i=1;i<=7;i++)
            System.out.println(ex1.weekday1(i));
    }

    public String weekday1(int day) throws Exception {
        int dayIndex = day-1;
        if (dayIndex<0 || dayIndex>=DAYS.length)
            throw new Exception("day must be in range 1 to 7");
        return DAYS[dayIndex];
    }






    public String _weekday1(int day) throws Exception {
        switch (day) {
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            case 7:
                return "Sunday";
            default:
                throw new Exception("day must be in range 1 to 7");
        }
    }

    public String weekday2(int day) throws Exception {
        if ((day < 1) || (day > 7)) throw new Exception("day must be in range 1 to 7");
        String[] days = {
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"
        };
        return days[day - 1];
    }
}
