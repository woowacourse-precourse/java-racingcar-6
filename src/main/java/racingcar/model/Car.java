package racingcar.model;

public class Car {
    private Name name;
    private int position;

    public Car(String carName) {
        this.name = new Name(carName);
    }

}
