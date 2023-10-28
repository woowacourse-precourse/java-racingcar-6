package racingcar.validator;

public class InputValidator {
    public static void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5글자 이하여야 합니다.");
        }
    }

    public static void validateTrialNumber(String inputNum) {
        for(int index=0; index<inputNum.length(); index++) {
            if (isInputNotDigit(inputNum, index)) {
                throw new IllegalArgumentException("시도할 횟수는 숫자만 입력해야 합니다.");
            }
        }
    }

    private static boolean isInputNotDigit(String inputNum, int index) {
        return !Character.isDigit(inputNum.charAt(index));
    }
}
