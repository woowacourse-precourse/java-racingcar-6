package racingcar.domain;


import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Validator {

    public void carNamesInputValidator(String input) {

        List<String> carList;

        String[] carString = input.split(",");
        carList = Arrays.asList(carString);

        /* 자동차가 하나일 경우 */
        if (carList.size() < 2) throw new IllegalArgumentException("경주가 시작되려면 이름을 두 개 이상 적어주세요");


        isContainSameName(carList);
        isProperLength(carList);

    }

    private void isContainSameName(List<String> carList) {
        List<String> checkList = new ArrayList<>();

        for (String carName : carList) {
            if (checkList.contains(carName)) throw new IllegalArgumentException("중복된 이름이 있습니다.");
            else checkList.add(carName);
        }
    }

    private void isProperLength(List<String> carList) {
        for (String carName : carList) {
            int len = carName.length();
            if (len > 5 || len < 1) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하입니다.");
            }
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
