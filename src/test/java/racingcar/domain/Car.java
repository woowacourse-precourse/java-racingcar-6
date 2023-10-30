package racingcar.domain;

public class Car {
    private int position;
    private final String name;

    public Car(String name, int position) {
        validateLengthOf(name);
        this.name = name;
        this.position = position;
    }

    public static Car of(String name, int position) {
        return new Car(name, position);
    }

    private void validateLengthOf(String name) {
        if (name.length() > 5 || name.length() < 1) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }

    public void move(int i) {
        if (i > 3) {
            this.position++;
        }
    }
}
