package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private static final String ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private static final String ASK_ROTATE_NUMBER = "시도할 회수는 몇회인가요?";

    public String enterCarNames() {
        System.out.println(ENTER_CAR_NAMES);

        return readLine();
    }

    public String enterRotateNumber() {
        System.out.println(ASK_ROTATE_NUMBER);

        return readLine();
    }
}
