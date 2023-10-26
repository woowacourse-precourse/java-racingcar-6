package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private static final String ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public String enterCarNames() {
        System.out.println(ENTER_CAR_NAMES);

        return readLine();
    }
}
