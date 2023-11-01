package racingcar.domain;

public class Car {
    private String name;
    private int dist;
    public Car(String name) {
        this.name = name;
        this.dist = 0;
    }
    public void move() {
        dist += 1;
    }
    public String getName() {
        return name;
    }
    public int getDist() {
        return dist;
    }
}
