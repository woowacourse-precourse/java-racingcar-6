package racingcar.Domain;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private static final int START_POSITION = 0;
    private static final int TICK = 1;
    private static final int MINIMUM_NAME_LENGTH = 1;
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private final String name;
    private int position;

    public Car(String name) {
        isValidName(name);
        this.name = name;
        this.position = START_POSITION;
    }

    private void isValidName(String name) {
        if(name.length() < MINIMUM_NAME_LENGTH || name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    "이름은 최소 "
                            + MINIMUM_NAME_LENGTH + "자에서 최대 "
                            + MAXIMUM_NAME_LENGTH + "자 사이로 입력하셔야 합니다.");
        }
    }

    public void moveForward(int isMoveAvailable) {
        if (isMoveAvailable >= MOVE_THRESHOLD) {
            this.position += TICK;
        }
    }

    public int findFasterPosition(int fastestPosition) {
        return Math.max(this.position, fastestPosition);
    }

    public boolean isSamePosition(int winnerPosition) {
        return this.position == winnerPosition;
    }

    public String makePositionString (String positionStamp) {
        return this.name + " : "
                + positionStamp.repeat(this.position);
    }

    public String getName() {
        return this.name;
    }
}
