public class Student implements Comparable<Student>{
   private String name,id;
   private int grade;

    public void setName(String name) {
        this.name = name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }
    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public int getGrade() {
        return grade;
    }

    public Student(String name, String id, int grade) {
        if (grade<=100 && grade >= 0){
            this.name = name;
            this.id = id;
            this.grade = grade;
        }
        else System.out.println("Eror: Iligal grade");
    }

    @Override
    public int compareTo(Student other) {
        if (this.getGrade()> other.getGrade())
            return -1;
        else if (this.getGrade()< other.getGrade())
            return 1;
        else if (this.getId().equals(other.getId()))
            return 0;
        else return 1;
    }

    public boolean equals (Student other) {
        if(this.compareTo(other)==0)
            return true;
        else return false;
    }

    @Override
    public String toString() {
        return name +" "+id+" "+grade;

    }

}
