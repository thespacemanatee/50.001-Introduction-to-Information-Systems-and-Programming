
import java.util.ArrayList;

//starting code
public class TemperatureAlert implements Subject {
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
        if (this.temperature > 35 || this.temperature < 10) {
            for (Observer o:observers) {
                o.update(temperature);
            }
        }
    }

    @Override
    public void register(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void unregister(Observer o) {
        this.observers.remove(o);
    }
}
