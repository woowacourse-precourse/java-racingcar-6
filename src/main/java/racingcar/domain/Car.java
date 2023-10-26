package racingcar.domain;

public class Car {
    private String name;
    private int position;

    private Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car nameOf(String input) {
        return new Car(input, 0);
    }

}
