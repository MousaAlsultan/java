public class MyDate {
    private int year;
    private int month;
    private int day;
    
    public static final String[] MONTHS = {
        "Jan", "Feb", "Mar", "Apr", "May", "Jun",
        "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    };
    
    public static final String[] DAYS = {
        "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
    };
    
    public static final int[] DAY_IN_MONTHS = {
        31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };
    
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    
    public static boolean isValidDate(int year, int month, int day) {
        if (year < 1 || year > 9999 || month < 1 || month > 12 || day < 1) {
            return false;
        }
        
        int maxDays = DAY_IN_MONTHS[month - 1];
        
        if (month == 2 && isLeapYear(year)) {
            maxDays = 29;
        }
        
        return day <= maxDays;
    }
    
    public static int getDayOfWeek(int year, int month, int day) {
        if (month < 3) {
            month += 12;
            year--;
        }
        
        int century = year / 100;
        year %= 100;
        
        int dayOfWeek = (day + 13 * (month + 1) / 5 + year + year / 4 + century / 4 + 5 * century) % 7;
        
        return dayOfWeek;
    }
    
    public MyDate(int year, int month, int day) {
        setDate(year, month, day);
    }
    
    public void setDate(int year, int month, int day) {
        if (isValidDate(year, month, day)) {
            this.year = year;
            this.month = month;
            this.day = day;
        } else {
            System.out.println("Invalid year, month, or day!");
        }
    }
    
    public void setYear(int year) {
        if (year >= 1 && year <= 9999) {
            this.year = year;
        } else {
            System.out.println("Invalid year!");
        }
    }
    
    public void setMonth(int month) {
        if (month >= 1 && month <= 12) {
            this.month = month;
        } else {
            System.out.println("Invalid month!");
        }
    }
    
    public void setDay(int day) {
        int maxDays = DAY_IN_MONTHS[month - 1];
        
        if (month == 2 && isLeapYear(year)) {
            maxDays = 29;
        }
        
        if (day >= 1 && day <= maxDays) {
            this.day = day;
        } else {
            System.out.println("Invalid day!");
        }
    }
    
    public int getYear() {
        return year;
    }
    
    public int getMonth() {
        return month;
    }
    
    public int getDay() {
        return day;
    }
    
    public String toString() {
        int dayOfWeek = getDayOfWeek(year, month, day);
        String dayOfWeekStr = DAYS[dayOfWeek];
        String monthStr = MONTHS[month - 1];
        
        return dayOfWeekStr + " " + day + " " + monthStr + " " + year;
    }
    
    public MyDate nextDay() {
        day++;
        
        int maxDays = DAY_IN_MONTHS[month - 1];
        
        if (month == 2 && isLeapYear(year)) {
            maxDays = 29;
        }
        
        if (day > maxDays) {
            day = 1;
            nextMonth();
        }
        
        return this;
    }
    
    public MyDate nextMonth() {
        month++;
        
        if (month > 12) {
            month = 1;
            nextYear();
        }
        
        return this;
    }
    
    public MyDate nextYear() {
        year++;
        
        if (month == 2 && day == 29 && !isLeapYear(year)) {
            day = 28;
        }
        
        return this;
    }
    
    public MyDate previousDay() {
        day--;
        
        if (day < 1) {
            previousMonth();
            
            int maxDays = DAY_IN_MONTHS[month - 1];
            
            if (month == 2 && isLeapYear(year)) {
                maxDays = 29;
            }
            
            day = maxDays;
        }
        
        return this;
    }
    
    public MyDate previousMonth() {
        month--;
        
        if (month < 1) {
            month = 12;
            previousYear();
        }
        
        return this;
    }
    
    public MyDate previousYear() {
        year--;
        
        if (month == 2 && day == 29 && !isLeapYear(year)) {
            day = 28;
        }
        
        return this;
    }
}
/*********************task#3***********/
public class TestStatements {
    public static void main(String[] args) {
        MyDate d1 = new MyDate(2012, 2, 28);
        System.out.println(d1);             // Tuesday 28 Feb 2012
        System.out.println(d1.nextDay());   // Wednesday 29 Feb 2012
        System.out.println(d1.nextDay());   // Thursday 1 Mar 2012
        System.out.println(d1.nextMonth()); // Sunday 1 Apr 2012
        System.out.println(d1.nextYear());  // Monday 1 Apr 2013

        MyDate d2 = new MyDate(2012, 1, 2);
        System.out.println(d2);                 // Monday 2 Jan 2012
        System.out.println(d2.previousDay());   // Sunday 1 Jan 2012
        System.out.println(d2.previousDay());   // Saturday 31 Dec 2011
        System.out.println(d2.previousMonth()); // Wednesday 30 Nov 2011
        System.out.println(d2.previousYear());  // Tuesday 30 Nov 2010

        MyDate d3 = new MyDate(2012, 2, 29);
        System.out.println(d3.previousYear());  // Monday 28 Feb 2011

        // MyDate d4 = new MyDate(2099, 11, 31); // Invalid year, month, or day!
        // MyDate d5 = new MyDate(2011, 2, 29);  // Invalid year, month, or day!
    }
}
