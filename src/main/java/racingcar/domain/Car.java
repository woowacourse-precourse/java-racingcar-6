package racingcar.domain;


public class Car {
    private static final int STANDARD_NUMBER = 4;
    private static final int MOVE_FORWARD = 1;
    private final Name name;
    private final Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public String getName() {
        return this.name.toString();
    }

    public int getPosition() {
        return this.position.toInt();
    }

    public void move(int randomNumber) {
        if (randomNumber > STANDARD_NUMBER) {
            this.position.move(MOVE_FORWARD);
        }
    }
}
