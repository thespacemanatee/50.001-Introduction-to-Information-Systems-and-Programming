//**SEE BELOW** modify AirPollutionAlert
//Necessary Import statements here

import java.util.ArrayList;

// **** YOU DO NOT NEED TO MODIFY THIS PART OF THE CODE -------
interface Observer{
    void update(double airPollutionIndex);
}

class Subscriber implements Observer{
    private Subject subject;
    private String observerId;
    public static String outputMessage = "";

    public Subscriber(String observerId, Subject subject){
        this.subject=subject;
        this.observerId = observerId;
        this.subject.register(this);		// register itself
    }

    @Override
    public void update(double airPollutionIndex) {
        String s = this.observerId + " received notification: " + airPollutionIndex;
        System.out.println(s);
        outputMessage += (s + " ");
    }
}

interface Subject{
    void register(Observer o);
    void unregister(Observer o);
    void notifyObservers();
}
//-------------------------------------------------------

class AirPollutionAlert implements Subject{
    private double airPollutionIndex;
    private final ArrayList<Observer> observerList = new ArrayList<>();

    public void setAirPollutionIndex(double airPollutionIndex) {
        this.airPollutionIndex = airPollutionIndex;
        if (airPollutionIndex>100) {
            notifyObservers();
        }
    }

    @Override
    public void register(Observer o) {
        observerList.add(o);
    }

    @Override
    public void unregister(Observer o) {
        observerList.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o:observerList) {
            o.update(airPollutionIndex);
        }
    }
}


/* Some information on test cases:
 Test Cases 1, 3, 5 and 8 use an airPollutionIndex that is less than 100
 The rest use an airPollutionIndex that is larger than 100 */
class Test{
    public static void main(String[] args) {
        AirPollutionAlert singaporeAlert = new AirPollutionAlert();
        Subscriber man = new Subscriber("man",singaporeAlert);
        Subscriber simon = new Subscriber("simon", singaporeAlert);

        singaporeAlert.setAirPollutionIndex(200);
        singaporeAlert.setAirPollutionIndex(50);
        singaporeAlert.setAirPollutionIndex(120);

        singaporeAlert.unregister(man);
        singaporeAlert.setAirPollutionIndex(300);
    }
}
