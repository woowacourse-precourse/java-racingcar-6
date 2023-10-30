package racingcar.util;

public class CarNameValidator {
    private String[] allCarNames;
    public boolean check(String carNames) {
        return isNull(carNames) && isSize(carNames) && isString();
    }

    private boolean isString() {
        for (String allCarName : allCarNames) {
            String regex = "^[a-zA-Z]+$";
            if (!allCarName.matches(regex)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSize(String carNames) {
        allCarNames = carNames.split(",");

        for (String carName : allCarNames) {
            int limit = 5;
            if (carName.isEmpty() || carName.length() > limit) {
                return false;
            }
        }
        return true;
    }

    private boolean isNull(String carNames) {
        return carNames != null && !carNames.trim().isEmpty();
    }
}
