package racingcar;

public class Car {

    private static final int BOUND = 4;
    private static final int maxNameLength = 5;
    private final String name;

    private int position = 0;

    public Car(String name) {
        if (name.length() > maxNameLength) {
            throw new IllegalArgumentException("자동차의 이름은 5글자 이하만 가능합니다.");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차의 이름이 제대로 입력되지 않았습니다.");
        }
        this.name = name;
    }

    public void move(int randomNumber) {
        if (randomNumber >= BOUND) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
