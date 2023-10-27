package racingcar.domain;

public class Car {

    private final String name;

    public Car(String name) {
        validateLength(name);
        this.name = name;
    }

    private static void validateLength(String name) {
        if(name.length() > 5) throw new IllegalArgumentException();
    }

}
