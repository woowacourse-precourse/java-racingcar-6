package racingcar.constant;

public class RacingGameConstant {

    // Constants for Car movement and initial position
    public static final int MOVE_THRESHOLD = 4;    // Determines when the car should move forward
    public static final int INITIAL_POSITION = 0;  // Car's starting position

    // Constants for random number generation range
    public static final int RANDOM_MIN = 0;        // Minimum boundary for random number generation
    public static final int RANDOM_MAX = 9;        // Maximum boundary for random number generation

    // Constants for validation
    public static final int MAX_CAR_NAME_LENGTH = 5;   // Maximum allowable characters for a car's name

    // Constants for test scenarios
    public static final int MOVING_FORWARD = 4;    // Represents a scenario where the car moves forward
    public static final int STOP = 3;              // Represents a scenario where the car doesn't move (just one less than MOVING_FORWARD)
}
