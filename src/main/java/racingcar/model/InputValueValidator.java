package racingcar.model;

public class InputValueValidator {

    // 자동차 입력값을 배열로 변환
    public String[] changeArrayType (String input) {
        String[] result = input.split(",");
        return result;
    }

    public void checkNameValidation(String[] input) throws IllegalArgumentException {
        for (String name : input) {
            verifyLength(name);
        }
    }

    public void verifyLength(String value) throws IllegalArgumentException {
        if(value.length() <= 0 || value.length() > 5) {
            throw new IllegalArgumentException("에러! 자동차 이름은 최대 다섯 글자이며 빈 칸을 입력할 수 없습니다.");
        }
    }

    public void checkDigit() {

    }
}
