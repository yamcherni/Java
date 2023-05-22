import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("avi","875543",60);
        Student s2 = new Student("moshe","237673",50);
        Student s3 = new Student("igor","22343",80);
        Student s4 = new Student("david","22343",90);
        Student s5 = new Student("avi","875543",60);

        SortedGroup <Student> studentGroup = new SortedGroup<Student>();
        studentGroup.add(s1);
        studentGroup.add(s2);
        studentGroup.add(s3);
        studentGroup.add(s4);
        studentGroup.add(s5);

        System.out.println("The Group created:");
        System.out.println(studentGroup.toString());

        Student s6 = new Student("avi","875543",60);
        studentGroup.add(s6);
        System.out.println("\n-----------------\n");
        System.out.println("Another avi added:");
        System.out.println(studentGroup.toString());

        studentGroup.remove(s1);
        System.out.println("\n-----------------\n");
        System.out.println("Avi delited:");
        System.out.println(studentGroup.toString());

        Student s7 = new Student("Grisha","8321543",70);
        studentGroup.add(s7);
        System.out.println("\n-----------------\n");
        System.out.println("Grisha added:");
        System.out.println(studentGroup.toString());

        System.out.println("\n-----------------\n");
        System.out.println("reduce with Grishas grade:");
        System.out.println(reduce(studentGroup,s7));
        System.out.println("\n-----------------\n");
        System.out.println("the original group after reduce:");
        System.out.println(studentGroup.toString());

    }


    public static <T> SortedGroup<T> reduce(SortedGroup<T> sGroup, T t){
        Iterator iterator = sGroup.interior();
        ArrayList<T> studentGroup2arr = sGroup.getArrayList();
        SortedGroup <Student> studentGroup2 = new SortedGroup<Student>();
                while (iterator.hasNext()){
                    String temp = iterator.next().toString();
                    String w1 = temp.substring(0,temp.indexOf(" "));
                    temp = temp.substring(w1.length()+1);
                    String w2 = temp.substring(0,temp.indexOf(" ")+1);
                    temp = temp.substring(w2.length());
                    String w3 = temp;
                    int grade = Integer.parseInt(w3);
                    if (t.toString().indexOf(-3)==1)
                        studentGroup2.add(new Student(w1,w2,grade));
                    else {
                    int gradeOfT = Integer.parseInt(t.toString().substring(t.toString().length()-2));
                    if (grade>gradeOfT)
                       studentGroup2.add(new Student(w1,w2,grade));
                }}
                return (SortedGroup<T>) studentGroup2;
            }
}