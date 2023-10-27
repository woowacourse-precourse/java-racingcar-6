package racingcar;

public class CarNameValidator {
    public void isValidName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("Car name must be no more than 5 characters.");
        }
    }
}
