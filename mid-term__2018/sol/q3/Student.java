package com.cheung.lib2018midterm;
//starting code
/*
public class Student  {
    private String id;

    public Student(String id) {
        this.id = id;

    }

}


 */
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
        System.out.println("Student " + this.id + " receives temperature alert: " + t);
    }
}

