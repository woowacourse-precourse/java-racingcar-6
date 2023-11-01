package racingcar.validation;

import racingcar.user.User;

public class Validator {
    private User user;

    public Validator(User user) {
        this.user = user;
    }

    public void checkCarNamesCount() {
        if (user.getRacingCarNames().length <= 1) {
            throw new IllegalArgumentException("?? 1?? ??? ??? ??????.");
        }
    }
    public void checkCarNamesLength() {
        for (String carName : user.getRacingCarNames()) {
            if (carName.trim().length() > 5){
                throw new IllegalArgumentException("??? ??? 5?? ????? ???.");
            }
        }
    }
}
