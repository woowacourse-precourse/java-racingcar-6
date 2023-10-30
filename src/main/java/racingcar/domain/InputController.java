package racingcar.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputController {
    public void insertCarNames() {
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String carNames = readLine();
    }
}
