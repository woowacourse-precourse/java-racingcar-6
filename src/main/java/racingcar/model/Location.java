package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.validator.BasicValidator;
import racingcar.validator.LocationValidator;

public record Location(int location) {

    private static final BasicValidator<Integer> locationValidator = new LocationValidator();

    public Location {
        locationValidator.validate(location);
    }

    public static Location init() {
        return new Location(0);
    }

    public Location move() {
        if (moveCondition()) {
            return new Location(location + 1);
        }
        return new Location(location);
    }

    private boolean moveCondition() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }
}
