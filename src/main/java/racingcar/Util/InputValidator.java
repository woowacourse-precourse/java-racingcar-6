package racingcar.Util;

import java.util.List;

public class InputValidator {

    public static void checkCarNameLength(List<String> inputStrList) {
        for (String str : inputStrList) {
            if (str.length() > 5 || str.length()==0) {
                throw new IllegalArgumentException("자동차의 이름은 5글자 이하여야 합니다.");
            }
        }
    }

    public static void checkIsNumber(String inputStr) {
        System.out.println(inputStr);
        if (inputStr == null || inputStr.isEmpty()) {
            throw new IllegalArgumentException("원하는 시도 횟수를 입력해주세요!");
        }
        for (char c : inputStr.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("원하는 시도 횟수를 숫자로 입력해주세요!");
            }
        }
    }
    // 콤마랑 콤마사이에 아무 값도 없다면? 예외처리 + 공백만 있다면?? 예외처리
}
