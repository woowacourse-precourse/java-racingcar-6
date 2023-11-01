package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String PRINT_READ_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String PRINT_READ_TRY_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String CAR_NAME_DELIMITER = ",";

    private InputView() {
    }

    public String readCarName() {
        System.out.println(PRINT_READ_CAR_NAME_MESSAGE);
        return getInput();
    }

    private static String getInput() {
        return Console.readLine();
    }
}
