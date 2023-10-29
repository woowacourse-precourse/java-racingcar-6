package racingcar.validation;

public class Validation {

    public void playerNameValidation(String playerName) {
        if (playerName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
