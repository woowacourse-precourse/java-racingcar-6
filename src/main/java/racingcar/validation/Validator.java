package racingcar.validation;

import static racingcar.util.print.constants.RacingGameConstants.MIN_ADD_CAR;
import static racingcar.util.print.constants.RacingGameConstants.MIN_CAR_NAME_LENGTH;

import racingcar.user.User;

public class Validator {
    private User user;

    public Validator(User user) {
        this.user = user;
    }

    public void checkCarNamesCount() {
        if (user.getRacingCarNames().length <= MIN_ADD_CAR) {
            throw new IllegalArgumentException("경주할 수 있는 자동차는 최소 1대 이상 등록해 주세요.");
        }
    }
    public void checkCarNamesLength() {
        for (String carName : user.getRacingCarNames()) {
        if (carName.trim().length() > MIN_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.");
            }
        }
    }
}
