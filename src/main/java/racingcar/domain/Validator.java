package racingcar.domain;


import java.util.Arrays;
import java.util.List;

public class Validator {

    public void carNamesInputValidator(String input) {

        List<String> carList;

        String[] carString = input.split(",");
        carList = Arrays.asList(carString);

        for (String s : carList) {
            isProperLength(s);
        }
    }

    private void isProperLength(String carName) {
        int len = carName.length();
        if (len > 5 || len < 1) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하입니다.");
        }
    }

    public void roundsInputValidator(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값을 입력하셨습니다.");
        }
    }
}
