package racingcar.validation;

public class RaceValidation {
    public void validationSeparator(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException("자동차 이름은 쉼표(,)로 구분해 주세요.");
        }
    }
    public void validationNameLength(String input) {
        if (input.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하만 가능합니다.");
        }
    }

    public void validationMoveTrailCount(String input) {
        for (int i = 0; i < input.length(); i++) {
            findDigit(input, i);
        }
    }

    private void findDigit(String input, int i) {
        if (!Character.isDigit(input.charAt(i))) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }

}
