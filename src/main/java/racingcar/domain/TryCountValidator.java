package racingcar.domain;

public class TryCountValidator {
    private final int tryCount;

    public TryCountValidator(String input){
        tryCount = convertStringToInt(input);
        validateNumber(tryCount);
    }

    private void validateNumber(int tryCount) {
        if (tryCount < 0){
            throw new IllegalArgumentException();
        }
    }

    private int convertStringToInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }
}
