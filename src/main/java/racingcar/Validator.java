package racingcar;

public class Validator {

    public void validateInput(String input) {
        if (input.length() > 10000000) {
            throw new IllegalArgumentException("입력값이 너무 깁니다. 입력값의 길이는 최대 1000만자 입니다.");
        }
//        if (input.matches("^[가-힣a-zA-Z]+$")) {
//            throw new IllegalArgumentException("")
//        }
    }
}