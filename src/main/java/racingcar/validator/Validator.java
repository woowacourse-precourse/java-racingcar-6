package racingcar.validator;

import java.util.List;

public class Validator {
    public void validateCarNameLength(List<String> carName) {
        if(carName.stream().anyMatch(name -> name.length() >= 5)) {
            throw new IllegalArgumentException("입력한 자동차 이름중에 5자가 넘는 이름이 있습니다.");
        }
    }

    public static void checkEnglishInput(String inputStr) {
        if (!inputStr.matches("^[a-zA-Z]*$")) {
            throw new IllegalArgumentException("입력한 값은 영어가 아닙니다. 영어 문자만 허용됩니다.");
        }
    }
}
