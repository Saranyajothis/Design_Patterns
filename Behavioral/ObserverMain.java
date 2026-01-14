package Behavioral;

import java.util.HashSet;
import java.util.Set;

//subject 
interface TemperatureSubject{
    void addObserver(TemperatureObserver observer);
    void removeObserver(TemperatureObserver observer);
    void notifyObservers();
}

//Observer
interface TemperatureObserver{
    void update (int temperature);
}

//Concrete Subject
class TemperatureStation implements TemperatureSubject{
    private Set<TemperatureObserver> observers;
    private int temperature;

    public TemperatureStation(int temperature){
        observers = new HashSet<>();
        this.temperature = temperature;
    }

    @Override
    public void addObserver(TemperatureObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(TemperatureObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(TemperatureObserver observer : observers){
            observer.update(temperature);

        }
    }

    public void setTemperature(int temperature){
        this.temperature = temperature;
        notifyObservers();
    }
}

//concrete observers
class Customer1 implements TemperatureObserver{
    @Override
    public void update(int temperature) {
        System.out.println("Customer 1 notified. Current Temperature: " + temperature);
    }
}

class Customer2 implements TemperatureObserver{
    @Override
    public void update(int temperature) {
        System.out.println("Customer 2 notified. Current Temperature: " + temperature);
    }
}


//main class
public class ObserverMain {
    public static void main(String[] args) {
        TemperatureStation ts = new TemperatureStation(34);
        Customer1 c1 = new Customer1();
        Customer2 c2 = new Customer2();

        ts.addObserver(c1);
        ts.addObserver(c2);
        ts.notifyObservers();

        //now calling set which calls notify()
        ts.setTemperature(28);
        ts.removeObserver(c2);
        ts.setTemperature(0);

    }
    
}
