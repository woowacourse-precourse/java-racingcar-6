package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.constant.RacingGameConstant.CARS_SPLIT_STRING;

public class InputView {

    private static final String ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(%s) 기준으로 구분)\n";

    private static final String ASK_ROTATE_NUMBER = "시도할 회수는 몇회인가요?";

    public String enterCarNames() {
        System.out.printf(ENTER_CAR_NAMES, CARS_SPLIT_STRING);

        return readLine();
    }

    public String enterRotateNumber() {
        System.out.println(ASK_ROTATE_NUMBER);

        return readLine();
    }
}
