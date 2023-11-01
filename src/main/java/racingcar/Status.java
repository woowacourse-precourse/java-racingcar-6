package racingcar;

public class Status {

    private String name;
    private int distance;

    public Status(String name, int distance) {
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
