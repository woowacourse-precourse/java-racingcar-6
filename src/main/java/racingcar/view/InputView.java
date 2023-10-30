package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_RACE_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    public String inputCarName() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        return Console.readLine();
    }

    public String inputRaceCount() {
        System.out.println(INPUT_RACE_COUNT_MESSAGE);
        return Console.readLine();
    }
}
