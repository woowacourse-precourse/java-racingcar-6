package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class inputView {

    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public static String inputCarNames() {
        System.out.println(INPUT_CAR_NAMES);
        String inputCarNames = Console.readLine();

        ValidationManager.validateCarNames(inputCarNames);

        return inputCarNames;
    }

}
