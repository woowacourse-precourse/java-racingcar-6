package racingcar.domain;

public class Car {

    private String name;
    private String position;

    public Car(String name) {
        validationNameLength(name);
        this.name = name;
    }

    private void validationNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

}
