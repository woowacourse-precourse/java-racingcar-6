package racingcar.domain;

public class InputValidation {
    public InputValidation(){}

    public boolean isValidName(String carName){
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }
        return true;
    }
}
