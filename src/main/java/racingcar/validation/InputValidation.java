package racingcar.validation;

public class InputValidation {
    public void carNameValidation(final String inputNames) {
        final String[] carNames = inputNames.split(",");
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
}
