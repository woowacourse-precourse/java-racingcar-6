package racingcar.domain;

public class Car {

    public static final int NAME_LENGTH_LIMIT = 5;
    private final String name;
    private Integer distance;

    public Car(String name) {
        validateLength(name);
        this.name = name;
        this.distance = 0;
    }

    private static void validateLength(String name) {
        if(name.length() > NAME_LENGTH_LIMIT) throw new IllegalArgumentException();
    }

    public void move() {
        distance++;
    }

}
