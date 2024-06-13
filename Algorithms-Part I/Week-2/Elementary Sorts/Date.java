
public class Date implements Comparable<Date> {
    private final int month, date, year;

    public Date(int m, int d, int y)
    {
        month = m;
        date = d;
        year = y;
    }    

    public int compareTo(Date that) {
        if (this.year < that.year) return -1;
        if (this.year > that.year) return 1;
        if (this.month < that.month) return -1;
        if (this.month > that.month) return 1;
        if (this.date < that.date) return -1;
        if (this.date > that.date) return 1;
        return 0;
    }
    @Override
    public String toString() {
        return month + "/" + date + "/" + year;
    }

    public static void main(String[] args) {
        Date date1 = new Date(3, 20, 2022);
        Date date2 = new Date(3, 14, 2023);
        Date date3 = new Date(2, 29, 2020);

        System.out.println("Comparing dates:");
        System.out.println(date1 + " vs " + date2 + ": " + date1.compareTo(date2));
        System.out.println(date2 + " vs " + date1 + ": " + date2.compareTo(date1));
        System.out.println(date1 + " vs " + date3 + ": " + date1.compareTo(date3));
        System.out.println(date3 + " vs " + date1 + ": " + date3.compareTo(date1));
        System.out.println(date1 + " vs " + date1 + ": " + date1.compareTo(date1));
    }
}

