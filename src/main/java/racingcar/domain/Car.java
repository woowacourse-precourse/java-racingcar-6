package racingcar.domain;

public class Car {
    private final String name;
    private Integer position = 0;

    public Car(String name) {
        isValidCarName(name);
        this.name = name;
    }

    private static void isValidCarName(String carName) {
        if (carName.length() < 1 || carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public void forward() {
        position++;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }
}
