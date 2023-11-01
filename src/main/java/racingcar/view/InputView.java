package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.CarList;

public class InputView {

    public static final String RACING_CAR_NAME_RULE_INFO = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String RACING_CAR_RUNNING_NUMBER_INFO = "시도할 회수는 몇회인가요?";

    public CarList addCarName() {
        return new CarList(Console.readLine());
    }

    public int gameRunningNumber() {
        return Integer.parseInt(Console.readLine());
    }

    public void gameStartLog() {
        System.out.println(RACING_CAR_NAME_RULE_INFO);
    }

    public void gameRunningNumberLog() {
        System.out.println(RACING_CAR_RUNNING_NUMBER_INFO);
    }
}
