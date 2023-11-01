package racingcar.validator;

import java.util.List;

public class InputValidator {
    public static void validateTryNumberType(String stringNumber) {
        if(stringNumber.isEmpty()){
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }

        try {
            Integer.parseInt(stringNumber);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("유효한 숫자 형식이 아닙니다." );
        }
    }

    public static void validateCarNameLength(List<String> carName) {
        if(carName.stream().anyMatch(name -> name.length() >= 5)) {
            throw new IllegalArgumentException("입력한 자동차 이름중에 5자가 넘는 이름이 있습니다.");
        }

        if(carName.size() <= 1) {
            throw new IllegalArgumentException("게임을 시작할 인원이 부족합니다.");
        }
    }
}
