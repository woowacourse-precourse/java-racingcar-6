package racingcar.validation;

public abstract class InputValidation {
    public static void verifyForEmptyValue(String inputValue){
        if (inputValue.equals("")){
            throw new IllegalArgumentException("[ERROR] 입력값이 공백일 수는 없습니다.");
        }
    }
}
