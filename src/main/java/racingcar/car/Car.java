package racingcar.car;

public class Car {
    private String name;

    public Car createCar(String name) {
        return new Car(name);
    }

    private Car(String name) {
        this.name = name;
    }
}
