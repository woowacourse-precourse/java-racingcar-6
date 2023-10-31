package racingcar.model;

public class Cars {

    private final String name;
    private int distance;

    public Cars(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void move() {
        distance++;
    }

}
