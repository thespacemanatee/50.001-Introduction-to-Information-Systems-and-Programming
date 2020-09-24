package com.cheung.lib2018midterm;

//starting code
/*
public interface Subject {

    void notifyObservers();

}

 */

public interface Subject {
    void register(Observer o);
    void unregister(Observer o);
    void notifyObservers();

}
