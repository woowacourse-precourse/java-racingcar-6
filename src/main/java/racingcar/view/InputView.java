package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final String MESSAGE_INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String MESSAGE_INPUT_TRY_COUNT = "시도할 회수는 몇회인가요?";

    public String inputCarName() {
        System.out.println(MESSAGE_INPUT_CAR_NAME);
        return Console.readLine();
    }

    public String inputTryCount() {
        System.out.println(MESSAGE_INPUT_TRY_COUNT);
        return Console.readLine();
    }

}
