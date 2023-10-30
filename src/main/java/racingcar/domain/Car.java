package racingcar.domain;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validateName(String name) {
        // TODO: 구현 필요
    }

    public void move() {
        // TODO: 구현 필요
    }

    public void tryMove(int randomNumber) {
        if (randomNumber >= 4) {
            move();
        }
    }
}
