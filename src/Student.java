public class Student {
    private int id;
    private String name;
    private String dept;
    private double cgpa;

    public Student(int id, String name, String dept, double cgpa) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.cgpa = cgpa;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDept() { return dept; }
    public double getCgpa() { return cgpa; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDept(String dept) { this.dept = dept; }
    public void setCgpa(double cgpa) { this.cgpa = cgpa; }

    @Override
    public String toString() {
        return "======================="
                +"\nID: "+id + "\nName: " + name
                +"\nDepartment: " + dept + "\nCGPA: " + cgpa;
    }
}
