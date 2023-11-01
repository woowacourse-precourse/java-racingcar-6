package racingcar.domain;

import static racingcar.constants.DomainConstant.*;

import racingcar.AppConfig;
import racingcar.validator.Validator;

public class Car {
    AppConfig appConfig = new AppConfig();
    private final String name;
    private int position;

    public Car(String name) {
        validateCarName(name);
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

    private void validateCarName(String name) {
        Validator carValidator = appConfig.carValidator();
        carValidator.validate(name);
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
