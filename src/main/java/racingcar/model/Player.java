package racingcar.model;

public class Player {
    private final String name;
    private int location;

    public Player(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return this.name;
    }

    public int getLocation() {
        return this.location;
    }

    public void move() {
        this.location++;
    }
}
