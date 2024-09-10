public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        Thread weatherThread = new Thread(weatherStation);

        ConcreteObserver display1 = new ConcreteObserver("Observer 1");
        ConcreteObserver display2 = new ConcreteObserver("Observer 2");
        ConcreteObserver display3 = new ConcreteObserver("Observer 3");

        // Register observers
        weatherStation.registerObserver(display1);
        weatherStation.registerObserver(display2);
        weatherStation.registerObserver(display3);

        // Start the weather station
        weatherThread.start();
        System.out.println("Weather station started.");

        // Let the simulation run for 15 seconds
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Remove observer 2
        weatherStation.removeObserver(display2);
        System.out.println("Observer  2 removed.");

        // Let the simulation run for another 15 seconds
        try {
            Thread.sleep(15000); // Let the simulation run for another 15 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Stop the weather station
        weatherStation.stop();
        System.out.println("Weather station stopped.");
    }
}