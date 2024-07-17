import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collection;

public class studentComparator {

    public static final Comparator<Student> BY_NAME = new ByName();
    public static final Comparator<Student> BY_SECTION = new ByName();

    private final String name;
    private final int section;

    //Constructor
    public studentComparator(String name, int section) {
        this.name = name;
        this.section = section;
    }

     // Getters
     public String getName() {
        return name;
    }

    public int getSection() {
        return section;
    }
    
    //Comparator class
    private static class ByName implements Comparator<Student> {
        public int compare(Student v, Student w) {
            return v.name.compareTo(w.name);
        }
    }

    private static class BySection implements Comparator<Student> {
        public int compare(Student v, Student w) {
            return v.section - w.section;
        }
    }
    

    
    
}
