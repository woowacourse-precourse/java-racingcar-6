package racingcar.validation;


import racingcar.User;

public class Validator {

    public void checkCarNameCount(User user) {
        String[] carNames = user.inputCarNames();
        if (carNames.length <= 1) {
            throw new IllegalArgumentException("??? ??? ???? ?? 2? ?????.");
        }
    }
}
