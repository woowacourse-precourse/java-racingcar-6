package racingcar.validation;

public class InputValidation {
    private final static String CAR_NAME_SEPARATOR = ",";
    public void carNameValidation(final String inputNames) {
        final String[] carNames = inputNames.split(CAR_NAME_SEPARATOR);
        for (String carName : carNames) {
            isNotNull(carName);
            isOverSize(carName);
        }
    }
    private void isNotNull(final String carName) {
        if(carName.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
    private void isOverSize(final String carName) {
        if(carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public void roundValidation(int round) {
        if(round < 0) {
            throw new IllegalArgumentException();
        }
    }
}
