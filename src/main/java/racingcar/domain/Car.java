package racingcar.domain;

public class Car {
    private static final int STARTING_POINT_INT = 0;
    private static final String STARTING_POINT_STRING = "";
    private static final int FORWARD_THRESHOLD = 4;
    private static final String MOVE_ONE_STEP_STRING = "-";
    private static final int MOVE_ONE_STEP_INT = 1;
    private final String name;
    private String positionString;
    private int positionInt;

    public Car(String name) {
        this.name = name;
        positionString = STARTING_POINT_STRING;
        positionInt = STARTING_POINT_INT;
    }

    public void move(int randomNum) {
        if (randomNum >= FORWARD_THRESHOLD) {
            positionString += MOVE_ONE_STEP_STRING;
            positionInt += MOVE_ONE_STEP_INT;
        }
    }

    public String getName() {
        return name;
    }

    public String getPositionString() {
        return positionString;
    }

    public int getPositionInt() {
        return positionInt;
    }
}
