package racingcar.domain;

public class Racer{
    private String name;
    private int distance;

    public Racer(String name) {
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void moveForward(int distance) {
        this.distance += distance;
    }

    public void printDistance() {
        System.out.println(this.name +
                " : " +
                "-".repeat(this.distance));
    }
}
