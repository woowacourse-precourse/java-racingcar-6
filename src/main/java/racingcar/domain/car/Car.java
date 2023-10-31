package racingcar.domain.car;

public class Car {

    private final String name;

    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getCarName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }

    protected void moveCar() {
        distance++;
    }


}
