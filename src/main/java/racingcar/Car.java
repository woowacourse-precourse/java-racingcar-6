package racingcar;

public class Car {

    private static final int BOUND_NUMBER = 4;
    private static final int MAX_NAME_SIZE = 5;

    private int position = 0;

    private final String name;

    public Car(String name) {
        if (name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능하다.");
        }
        this.name = name;
    }

    public void move(int number) {
        if (number >= BOUND_NUMBER) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
