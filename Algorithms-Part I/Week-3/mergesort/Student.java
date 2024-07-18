import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;

public class Student{

    public static final Comparator<Student> BY_NAME = new ByName();
    public static final Comparator<Student> BY_SECTION = new BySection();

    private final String name;
    private final int section;

    //Constructor
    public Student(String name, int section) {
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

    //Overriding toString() method for easy display
    @Override
    public String toString() {
        return "Student{name='" + name + "' , section = " + section + "}";
    }
    
    //Main methd to demonstarate comparators
    public static void main(String[] args){
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 3));
        students.add(new Student("Bob", 1));
        students.add(new Student("Charlie", 2));
        students.add(new Student("Dave", 3));

        System.out.println("Original list:");
        for (Student s : students) {
            System.out.println(s);
        }
        
        // Sorting by name
        Collections.sort(students, Student.BY_NAME);
        System.out.println("\nSorted by name:");
        for (Student s : students) {
            System.out.println(s);
        }

        // Sorting by section
        Collections.sort(students, Student.BY_SECTION);
        System.out.println("\nSorted by section:");
        for (Student s : students) {
            System.out.println(s);
        }
    }

}
