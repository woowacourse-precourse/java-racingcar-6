package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String CAR_NAME_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";
    private static final String MOVING_COUNT_REQUEST_MESSAGE = "시도할 회수는 몇회인가요?";

    public static String readCarName() {
        System.out.print(CAR_NAME_REQUEST_MESSAGE);
        return readLine();
    }
}
