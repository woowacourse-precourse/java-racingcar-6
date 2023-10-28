package racingcar.validation;

public abstract class InputValidation {
    public static void verifyForEmptyValue(String inputValue){
        if (inputValue.equals("")){
            throw new IllegalArgumentException("[ERROR] 입력값이 공백일 수는 없습니다.");
        }
    }

    public static void verifyForSpaceValue(String inputValue){
        String eliminateSpaceValue = inputValue.replaceAll(" ", "");
        if (!inputValue.equals(eliminateSpaceValue)){
            throw new IllegalArgumentException("[ERROR] 입력값에 공백이 포함되었습니다.");
        }
    }
}
