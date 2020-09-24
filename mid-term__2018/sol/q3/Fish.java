package com.cheung.lib2018midterm;

/*
public class Fish  {
    private String id;

    public Fish(String id) {
        this.id = id;

    }

}


 */

public class Fish implements Observer {
    private String id;
    private Subject subject;

    public Fish(String id, Subject subject) {
        this.id = id;
        this.subject = subject;
        this.subject.register(this);

    }

    @Override
    public void update(int t) {
        System.out.println("Fish " + this.id + " receives temperature alert: " + t);
    }
}

