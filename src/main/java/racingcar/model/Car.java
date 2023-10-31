package racingcar.model;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;

    private String name;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 " + MAX_NAME_LENGTH + "자를 초과할 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        this.position++;
    }

    public void tryMove(int randomNumber) {
        if (randomNumber >= 4) {
            move();
        }
    }
}
