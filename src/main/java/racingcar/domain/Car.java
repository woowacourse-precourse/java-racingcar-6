package racingcar.domain;

import constants.DomainConstant;
import racingcar.AppConfig;
import racingcar.validator.Validator;

public class Car {
    AppConfig appConfig = new AppConfig();
    private final String name;
    private int position;

    public Car(String name) {
        Validator carValidator = appConfig.carValidator();
        carValidator.validate(name);
        this.name = name;
        this.position = DomainConstant.INITIAL_POSITION;
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
            return DomainConstant.WHEN_SUCCESS_MOVE_DISTANCE;
        }
        return DomainConstant.WHEN_FAIL_MOVE_DISTANCE;
    }

    private boolean isSkillSufficient(int drivingSkill) {
        return drivingSkill >= DomainConstant.SUFFICIENT_DRIVING_SKILL_CRITERIA_VALUE;
    }
}
