package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    public final String ANNOUNCEMENT_INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public final String ANNOUNCEMENT_INPUT_MOVE_COUNT = "시도할 회수는 몇회인가요?";

    public Game() {
        init();
    }

    private void init() {
        System.out.println(this.ANNOUNCEMENT_INPUT_CAR_NAMES);
        String[] carNameArray = Console.readLine().split(",");
        Validator.validateCarNameArray(carNameArray);

        System.out.println(this.ANNOUNCEMENT_INPUT_MOVE_COUNT);
        String inputMoveCountString = Console.readLine();
        Validator.validateMoveCount(inputMoveCountString);
    }



}
