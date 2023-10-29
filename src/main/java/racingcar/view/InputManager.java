package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
    private final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    public String[] inputCarNames() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        String[] carNames = Console.readLine().split(",");
        Console.close();
        return carNames;
    }

    public String inputTryCount() {
        System.out.println(INPUT_TRY_COUNT_MESSAGE);
        String tryCount = Console.readLine();
        Console.close();
        return tryCount;
    }


}
