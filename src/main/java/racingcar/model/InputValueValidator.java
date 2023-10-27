package racingcar.model;

public class InputValueValidator {

    // 자동차 입력값을 배열로 변환
    public String[] changeArrayType (String input) {
        String[] result = input.split(",");
        return result;
    }

    // 자동차 이름 입력값 검증
    public void checkNameValidation(String[] input) throws IllegalArgumentException {
        for (String name : input) {
            verifyLength(name);
        }
    }

    public void verifyLength(String value) throws IllegalArgumentException {
        if(value.isEmpty()) {
            throw new IllegalArgumentException("에러! 빈 칸이나 쉼표를 입력할 수 없습니다.");
        }
        if(value.length() > 5) {
            throw new IllegalArgumentException("에러! 최대 다섯 글자까지만 입력해야 합니다.");
        }
    }

    // 이동 횟수 입력값 검증
    public void checkDigit(String value) throws IllegalArgumentException {
        try {
            int intValue = Integer.parseInt(value);
            if (intValue <= 0) {
                throw new IllegalArgumentException("에러! 이동 횟수는 1 이상의 정수만 입력해야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("에러! 이동 횟수는 정수만 입력해야 합니다.");
        }
    }
}
