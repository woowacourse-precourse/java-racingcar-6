package racingcar.domain;

public class Car extends Vehicle {

    public Car(String name) {
        this.name = name;
        this.distance = new Distance();
    }

    @Override
    public void advance() {
        this.distance.increaseDistance();
    }
}
