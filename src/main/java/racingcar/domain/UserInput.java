package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserInput {
    public String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarNames = Console.readLine();
        checkCommasInputCarNames(inputCarNames);
        checkLengthInputCarNames(inputCarNames);
        checkDupInputCarNames(inputCarNames);
        return splitInputCarNames(inputCarNames);
    }

    public static void checkCommasInputCarNames(String inputCarNames) {
        if (inputCarNames.length() > 5 && !inputCarNames.contains(",")) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하의 길이로 쉼표(,)를 기준으로 구분해주세요.");
        }
    }

    public static void checkLengthInputCarNames(String inputCarNames) {
        String[] carNames = splitInputCarNames(inputCarNames);
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해주세요.");
            }
        }
    }

    public static void checkDupInputCarNames(String inputCarNames) {
        List<String> dupCheckList = new ArrayList<>();
        String[] carNames = splitInputCarNames(inputCarNames);
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

    public int inputTryNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        String inputTryNumber = Console.readLine();
        checkInputTryNumber(inputTryNumber);
        return Integer.parseInt(inputTryNumber);
    }

    public static void checkInputTryNumber(String inputTryNumber) {
        try {
            Integer.parseInt(inputTryNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자로 입력해주세요.");
        }
    }
}
