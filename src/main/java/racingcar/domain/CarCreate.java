package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class CarCreate {
    public String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분)");
        String inputCarNames = Console.readLine();
        checkCommasInputCarNames(inputCarNames);
        checkDuplicationInputCarNames(inputCarNames);
        return splitInputCarNames(inputCarNames);
    }

    public static void checkCommasInputCarNames(String inputCarNames) {
        if (inputCarNames.length() > 5 && !inputCarNames.contains(",")) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하의 길이로 쉼표(,)를 기준으로 구분해주세요.");
        }
    }
    public static void checkDuplicationInputCarNames(String inputCarNames) {
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

}


