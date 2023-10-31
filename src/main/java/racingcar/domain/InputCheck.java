package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class InputCheck {

    public static Object[] checkUserInput(String inputCarNames, String inputTryNumber) {
        String[] carNames = splitInputCarNames(inputCarNames);

        checkCommasInputCarNames(inputCarNames);
        checkLengthInputCarNames(carNames);
        checkDupInputCarNames(carNames);
        checkInputTryNumber(inputTryNumber);

        Object[] inputData = new Object[2];
        inputData[0] = carNames;
        inputData[1] = Integer.parseInt(inputTryNumber);
        return inputData;
    }

    private static void checkCommasInputCarNames(String inputCarNames) {
        if (inputCarNames.length() > 5 && !inputCarNames.contains(",")) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하의 길이로 쉼표(,)를 기준으로 구분해주세요.");
        }
    }

    private static void checkLengthInputCarNames(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해주세요.");
            }
        }
    }

    private static void checkDupInputCarNames(String[] carNames) {
        List<String> dupCheckList = new ArrayList<>();
        for (String carName : carNames) {
            if (dupCheckList.contains(carName)) {
                throw new IllegalArgumentException("자동차 이름은 중복없이 설정해주세요.");
            }
            dupCheckList.add(carName);
        }
    }

    private static String[] splitInputCarNames(String inputCarNames) {
        return inputCarNames.split(",");
    }

    private static void checkInputTryNumber(String inputTryNumber) {
        try {
            Integer.parseInt(inputTryNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자로 입력해주세요.");
        }
    }
}
