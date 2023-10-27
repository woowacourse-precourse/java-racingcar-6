package racingcar.domain;

public class Car {

    private final String name;
    private Integer distance;

    public Car(String name) {
        validateLength(name);
        this.name = name;
        this.distance = 0;
    }

    private static void validateLength(String name) {
        if(name.length() > 5) throw new IllegalArgumentException();
    }

    public void move() {
        distance++;
    }

}
