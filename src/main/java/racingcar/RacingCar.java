package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.validator.UserInputValidator;

public class RacingCar {
    private final String name;
    private int location;

    public RacingCar(String name) {
        UserInputValidator.validCarNameLength(name);
        this.name = name;
        this.location = 0;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void move(boolean isMove) {
        if (isMove) {
            this.location++;
        }
    }

    public boolean isMove() {
        int pickNumberInRange = Randoms.pickNumberInRange(0, 9);
        return pickNumberInRange >= 4;
    }
}
