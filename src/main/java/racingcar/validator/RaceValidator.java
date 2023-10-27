package racingcar.validator;

public class RaceValidator {

    public void validateSeparator(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException("자동차 이름은 쉼표(,)를 기준으로 구분해 주세요.");
        }
    }

    public void validateCarname(String carname) {
        if (carname.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public void validateMoveTrialCount(String input) {
        for (int i = 0; i< input.length(); i++) {
            findDigit(input, i);
        }
    }

    private void findDigit(String input, int i) {
        if (!Character.isDigit(input.charAt(i))) {
            throw new IllegalArgumentException("숫자만 입력해 주세요.");
        }
    }
}
