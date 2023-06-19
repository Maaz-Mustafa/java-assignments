public class Teacher extends Person{
    private String department;

    private String specialization;

    public Teacher(){
        super();
    }

    public Teacher(String department, String specialization) {
        this.department = department;
        this.specialization = specialization;
    }

    public Teacher(String name, int age, String department, String specialization) {
        super(name, age);
        this.department = department;
        this.specialization = specialization;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "department='" + department + '\'' +
                ", specialization='" + specialization + '\'' +
                '}';
    }
}
