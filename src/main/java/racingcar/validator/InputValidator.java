package racingcar.validator;

public class InputValidator {

    // 11. 자동차 이름이 5글자 이하인지 검사하는 메서드
    public static void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5글자 이하여야 합니다.");
        }
    }

    //12. 시도할 횟수를 입력할 때 입력한 값이 숫자로만 이루어져 있는지 검사하는 메서드
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
