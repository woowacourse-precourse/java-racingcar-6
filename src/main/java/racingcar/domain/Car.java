package racingcar.domain;

public class Car {
    private final int MAX_CAR_NAME_LENGTH = 5;
    private final int INITIAL_POSITION = 0;
    private final int SUFFICIENT_DRIVING_SKILL_CRITERIA_VALUE = 4;
    private final int WHEN_SUCCESS_MOVE_DISTANCE = 1;
    private final int WHEN_FAIL_MOVE_DISTANCE = 0;
    private final String name;
    private int position;

    public Car(String name) {
        this.name = validCarName(name);
        this.position = INITIAL_POSITION;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int drivingSkill) {
        position += calculateMoveDistance(drivingSkill);
    }

    private int calculateMoveDistance(int drivingSkill) {
        if (isSkillSufficient(drivingSkill)) {
            return WHEN_SUCCESS_MOVE_DISTANCE;
        }
        return WHEN_FAIL_MOVE_DISTANCE;
    }

    private boolean isSkillSufficient(int drivingSkill) {
        return drivingSkill >= SUFFICIENT_DRIVING_SKILL_CRITERIA_VALUE;
    }

    private String validCarName(String name) {
        if (isBlank(name) || isValidCarNameLength(name)) {
            throw new IllegalArgumentException();
        }
        return name;
    }

    private boolean isBlank(String name) {
        return name == null || name.isBlank();
    }

    private boolean isValidCarNameLength(String name) {
        return name.length() > MAX_CAR_NAME_LENGTH;
    }
}
