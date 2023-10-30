package racingcar.domain;

public class Car {
    private String name;
    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    protected Car(){
    }

    public void increaseDistance() {
        distance++;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
