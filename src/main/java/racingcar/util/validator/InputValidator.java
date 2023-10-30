package racingcar.util.validator;

public class InputValidator {
    public void isStringEmpty(String str) {
        if(str == null || str.isBlank()){
            throw new IllegalArgumentException("입력받은 값이 없습니다.");
        }
    }
}
