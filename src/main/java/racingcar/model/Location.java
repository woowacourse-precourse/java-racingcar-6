package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.validator.BasicValidator;
import racingcar.validator.LocationValidator;

public record Location(int location) {

    private static final int MOVE_CONDITION = 4;
    private static final int START_LOCATION = 0;
    private static final int MOVE_VALUE = 1;

    private static final BasicValidator<Integer> locationValidator = new LocationValidator();

    public Location {
        locationValidator.validate(location);
    }

    public static Location init() {
        return new Location(START_LOCATION);
    }

    public Location move() {
        if (isMovable()) {
            return new Location(location + MOVE_VALUE);
        }
        return new Location(location);
    }

    private boolean isMovable() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= MOVE_CONDITION;
    }
}
