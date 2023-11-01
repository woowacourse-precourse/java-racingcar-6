package racingcar.validator;

public class NumberOfTimesValidator implements Validator<String> {

    @Override
    public void validate(String target) {
        validateContainingOnlyNumbers(target);
        validateByRange(target);
    }

    private void validateContainingOnlyNumbers(String target) {
        if (!target.matches("^-?[0-9]+$")) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    private void validateByRange(String target) {
        try {
            int num = Integer.parseInt(target);

            if (num < 1) {
                throw new IllegalArgumentException("유효한 숫자 범위가 아닙니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자 범위가 아닙니다.");
        }
    }
}
