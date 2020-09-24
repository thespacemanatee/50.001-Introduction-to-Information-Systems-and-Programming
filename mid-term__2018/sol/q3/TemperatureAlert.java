package com.cheung.lib2018midterm;

import java.util.ArrayList;

//starting code
/*
public class TemperatureAlert {
    private int temperature;

    public TemperatureAlert() {
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }



}

 */


public class TemperatureAlert implements Subject{
    private int temperature;
    private ArrayList<Observer> observers;

    public TemperatureAlert() {
        observers = new ArrayList<>();
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        if ((this.temperature <10) || (this.temperature > 35))
            for (Observer o: observers)
                o.update(this.temperature);
    }

    @Override
    public void register(Observer o) {
        observers.add(o);
    }

    @Override
    public void unregister(Observer o) {
        observers.remove(o);
    }


}
