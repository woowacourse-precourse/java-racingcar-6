package racingcar.domain;

public class Car {
    public final String name;
    public Integer position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public void go() {
        this.position ++;
    }
}
