import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter map type: ");
        String type = scanner.nextLine();

        Game game = new Game();
        Map map = game.createMap("Wilderness", 10, 5);
        map.display();
    }

    public Map createMap(String type, int width, int height) {
        if (type.equals("City")) {
            return new CityMap(width, height);
        } else if (type.equals("Wilderness")) {
            return new WildernessMap(width, height);
        } else {
            throw new IllegalArgumentException("Unknown map type");
        }
    }
}