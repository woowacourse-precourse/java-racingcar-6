package racingcar.model;

public class Car {
    private String name;
    private Long distance;

    public Car(String name) {
        this.name = validName(name);
        this.distance = 0L;
    }

    public String getName() {
        return this.name;
    }

    private String validName(String name) throws IllegalArgumentException {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
        return name;
    }
}
