package racingcar;

public class CarNameValidator {
    public void isValidName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
