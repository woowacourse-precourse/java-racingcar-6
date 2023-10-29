package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    public final String ANNOUNCEMENT_INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public Game() {
        init();
    }

    private void init() {
        System.out.println(this.ANNOUNCEMENT_INPUT_CAR_NAMES);
        String[] carNameArray = Console.readLine().split(",");
        Validator.validateCarNameArray(carNameArray);
    }

}
