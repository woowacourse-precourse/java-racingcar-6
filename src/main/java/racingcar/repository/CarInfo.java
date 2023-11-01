package racingcar.repository;

public class CarInfo {
    private String name;
    private int distance;

    public CarInfo(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
