package racingcar.domain;

import racingcar.AppConfig;
import racingcar.validator.CarValidator;
import racingcar.validator.Validator;

public class Car {
    AppConfig appConfig = new AppConfig();
    private final int INITIAL_POSITION = 0;
    private final int SUFFICIENT_DRIVING_SKILL_CRITERIA_VALUE = 4;
    private final int WHEN_SUCCESS_MOVE_DISTANCE = 1;
    private final int WHEN_FAIL_MOVE_DISTANCE = 0;
    private final String name;
    private int position;

    public Car(String name) {
        Validator carValidator = appConfig.carValidator();
        carValidator.validate(name);
        this.name = name;
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
}
