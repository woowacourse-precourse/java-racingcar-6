package racingcar.model;

public class Car {
    private Name name;
    private int position;

    public Car(String carName) {
        Name name = new Name(carName);
    }

}
