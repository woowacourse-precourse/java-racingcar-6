package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.RacingUtils;

public class RacingGameController {

    RacingUtils racingUtils = new RacingUtils();

    public void gameStart() {
        racingUtils.showEnterMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Console.readLine();
    }
}
