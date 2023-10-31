package racingcar.domain;

public class Car {

    private final String name;
    private int position = 0;
    private static final int MAX_NAME_SIZE = 5;
    private static final int MIN_FORWARDABLE_NUMBER = 4;

    private Car(String name) {
        this.name = name;
    }

    public static Car of(String name) {
        validateNameSize(name);
        return new Car(name);
    }

    public void race(int number) {
        if (isForwardable(number)) {
            this.position++;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    @Override
    public String toString() {
        return getName() + " : " + "-".repeat(getPosition());
    }

    private static void validateNameSize(String name) {
        if (name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }

    private boolean isForwardable(int number) {
        return number >= MIN_FORWARDABLE_NUMBER;
    }
}
