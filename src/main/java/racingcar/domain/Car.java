package racingcar.domain;

public class Car {
    private final static int NAME_LENGTH_CRITERION = 5;
    private final static int INIT_POSITION_CRITERION = 0;
    private final String name;
    private Position position;  // final 제거

    private Car(final String name) {
        this.name = name;
        this.position = new Position(INIT_POSITION_CRITERION);
    }

    public static Car fromName(String name) {
        validateNameLength(name);
        return new Car(name);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position.getPosition();
    }

    public void moveForward(int number) {
        if (position.isMovable(number)) {
            this.position = this.position.move();
        }
    }

    private static void validateNameLength(String name) {
        if (name.length() > NAME_LENGTH_CRITERION) {
            throw new IllegalArgumentException("이름은 5자 이내로 작성해야 합니다.");
        }
    }
}
