package com.cheung.lib2018midterm;

public class TestTemperatureAlert {
    public static void main(String[] args) {
        TemperatureAlert westCoast = new TemperatureAlert();
        Student s1 = new Student("s1", westCoast);
        Student s2 = new Student("s2", westCoast);

        westCoast.setTemperature(40);
        westCoast.setTemperature(25);
        westCoast.setTemperature(5);

        westCoast.unregister(s1);
        Student s3 = new Student("s3", westCoast);
        Fish f1 = new Fish("f1", westCoast);

        westCoast.setTemperature(2);


        //////

        Fish f2 = new Fish("f2", westCoast);
        Student s4 = new Student("s4", westCoast);
        westCoast.unregister(f1);

        westCoast.setTemperature(4);
        westCoast.setTemperature(15);
        westCoast.setTemperature(55);

/*
Student s1 receives temperature alert: 40
Student s2 receives temperature alert: 40
Student s1 receives temperature alert: 5
Student s2 receives temperature alert: 5
Student s2 receives temperature alert: 2
Student s3 receives temperature alert: 2
Fish f1 receives temperature alert: 2
Student s2 receives temperature alert: 4
Student s3 receives temperature alert: 4
Fish f2 receives temperature alert: 4
Student s4 receives temperature alert: 4
Student s2 receives temperature alert: 55
Student s3 receives temperature alert: 55
Fish f2 receives temperature alert: 55
Student s4 receives temperature alert: 55

 */


    }
}
