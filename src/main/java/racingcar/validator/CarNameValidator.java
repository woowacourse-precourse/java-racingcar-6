package racingcar.validator;

public class CarNameValidator extends CarNamesInputValidator {

    @Override
    public void validate(String carName) {
        hasSpecialCharacters(carName);
        isCarNameLengthValid(carName);
    }
}
