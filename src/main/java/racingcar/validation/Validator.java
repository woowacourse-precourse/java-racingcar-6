package racingcar.validation;


import racingcar.User;

public class Validator {

    public void checkCarNameCount(User user) {
        String[] carNames = user.inputCarNames();
        if (carNames.length <= 1) {
            throw new IllegalArgumentException("??? ??? ???? ?? 2? ?????.");
        }
    }
    public void checkCarNameLength(User user) {
        String[] carNames = user.inputCarNames();
        for (String carName : carNames) {
            carNameMaxLength(carName);
        }
    }

    private static void carNameMaxLength(String carName) {
        if (carName.trim().length() > 5) {
            throw new IllegalArgumentException("??? ??? 5?? ???? ???.");
        }
    }
}
