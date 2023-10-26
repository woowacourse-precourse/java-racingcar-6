package racingcar;

public class PlayerName {

    public void validateLength(String rawName) {
        if (isLengthOverFive(rawName)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isLengthOverFive(String rawName) {
        return rawName.length() > 5;
    }
}
