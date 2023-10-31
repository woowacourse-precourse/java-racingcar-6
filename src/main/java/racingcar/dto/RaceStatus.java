package racingcar.dto;


public class RaceStatus {

    private final String name;
    private final int distance;

    public RaceStatus(String name, int distance) {
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
