import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherStation implements Runnable {
    private List<Observer> observers;
    private int temperature;
    private boolean running;

    public WeatherStation() {
        observers = new ArrayList<>();
        temperature = new Random().nextInt(40); // Initial random temperature
        running = true;
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }

    private void updateTemperature() {
        Random random = new Random();
        int change = random.nextInt(3) - 1; // -1, 0, or +1
        temperature = Math.max(0, Math.min(100, temperature + change));
    }

    @Override
    public void run() {
        Random random = new Random();
        while (running) {
            updateTemperature();
            notifyObservers();
            try {
                Thread.sleep(random.nextInt(5000) + 1000); // Sleep for 1-5 seconds
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void stop() {
        running = false;
    }
}