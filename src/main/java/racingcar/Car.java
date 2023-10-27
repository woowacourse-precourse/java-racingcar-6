package racingcar;

public class Car {
    private String name;
    private Integer position;

    private Car(String name, Integer position) {
        this.name = name;
        this.position = position;
    }

    public static Car of(String name) {
        validateCarName(name);
        return new Car(name, 0);
    }

    private static void validateCarName(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
