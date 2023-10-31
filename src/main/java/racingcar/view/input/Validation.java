package racingcar.view.input;

public class Validation {
    public void areAllInFiveLength(String[] names) {
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException(ErrorConstants.OVER_FIVE_LENGTH_ERROR);
            }
        }
    }
}
