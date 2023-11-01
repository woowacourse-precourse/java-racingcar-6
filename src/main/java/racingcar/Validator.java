package racingcar;

public class Validator {

    static void carNames(String[] carNames) throws IllegalArgumentException {
        for (String carName : carNames) {
            if (carName.isEmpty()) {
                throw new IllegalArgumentException();
            }
            if (carName.contains(" ")) {
                throw new IllegalArgumentException();
            }
            if (carName.length() > Constant.CARNAME_MAX_LENGTH) {
                throw new IllegalArgumentException();
            }
        }
    }

    static int tryCountInput(String tryCountString) throws IllegalArgumentException {
        try {
            return Integer.parseInt(tryCountString);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
