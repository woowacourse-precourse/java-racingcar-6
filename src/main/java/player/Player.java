package player;

public class Player {
    private final String name;
    private Car car;

    public Player(String playerName) {
        this.name = playerName;
    }

    public String getPlayerName() {
        return name;
    }

    public int getDistance() {
        return car.getDistance();
    }

    public void selectNewCar() {
        car = new Car();
    }

    public void play() {
        if (car != null) {
            car.tryMove();
        }
    }
}
