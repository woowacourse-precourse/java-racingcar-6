package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private static final String REQUEST_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_MOVING_COUNT = "시도할 회수는 몇회인가요?";

    public static String readCarName() {
        System.out.println(REQUEST_CAR_NAME);
        return readLine();
    }

    public static int readMovingCount() {
        System.out.println(REQUEST_MOVING_COUNT);
        return Integer.parseInt(readLine());
    }
}
