//starting code
public class Student implements Observer {
    private String id;
    private Subject subject;

    public Student(String id, Subject subject) {
        this.id = id;
        this.subject = subject;
        this.subject.register(this);

    }

    @Override
    public void update(int t) {
        System.out.println("Student " + id + " receives temperature alert: " + t);
    }
}
