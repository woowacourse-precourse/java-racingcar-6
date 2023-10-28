package racingcar.validator;

public class InputValidator {

    private final String CarNameRegex = "\\w+(\\s+\\w+)*(,\\w+(\\s+\\w+)*)*"; // ,뒤 공백은 비허용/이름 사이 공백은 허용

    public void validateInputCarName(String carName) {
        if (!carName.matches(CarNameRegex)) {
            throw new IllegalArgumentException();
        }
    }
}
