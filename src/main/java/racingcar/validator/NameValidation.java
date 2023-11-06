package racingcar.validator;

import java.util.Collections;
import java.util.List;
import racingcar.util.InputManufacture;

public class NameValidation {

    public void validate(String input) {
        checkWord(input);
        checkDuplicate(input);
        checkCount(input);
    }

    private void checkWord(String input) {
        if (!input.matches("^([a-zA-Z]{1,5})(,[a-zA-Z]{1,5})*$")) {
            throw new IllegalArgumentException("5글자 이하의 영어 대소문자만 가능하고 쉼표 구분이 필요합니다");
        }
    }

    private void checkDuplicate(String input) {
        InputManufacture inputManufacture = new InputManufacture();
        List<String> carCheckList = inputManufacture.makeNameList(input);
        for (String s : carCheckList) {
            if (Collections.frequency(carCheckList, s) > 1) {
                throw new IllegalArgumentException("중복된 자동차 이름은 허용되지 않습니다");
            }
        }
    }

    private void checkCount(String input) {
        String[] carCheckList = input.split((","));
        if (carCheckList.length < 2) {
            throw new IllegalArgumentException("최소한 자동차 이름을 2개 이상 입력해야 합니다");
        }
    }
}