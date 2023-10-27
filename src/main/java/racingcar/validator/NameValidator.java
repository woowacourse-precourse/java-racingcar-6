package racingcar.validator;

public class NameValidator implements BasicValidator<String> {

    @Override
    public void validate(String carName) {
        hasSpecialCharacters(carName);
        isCarNameLengthValid(carName);
    }

    private void hasSpecialCharacters(String input) {
        if (!input.matches("^[a-zA-Z0-9\\s가-힣]*$")) {
            throw new IllegalArgumentException("자동차 이름에는 특수문자가 포함될 수 없습니다.");
        }
    }

    private void isCarNameLengthValid(String carName) {
        if (carName.length() > 5 || carName.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상, 5자 이하만 가능합니다.");
        }
    }
}
