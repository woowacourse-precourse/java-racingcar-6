package racingcar.domain;

import racingcar.util.OutputUtil;
import racingcar.util.RacingCarGameUtil;

public interface RacingCarGame {

    String GAME_START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    String ASK_GAME_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    String VIEW_WINNER_MESSAGE = "최종 우승자 : ";
    String GAME_RESULT_MESSAGE = "실행 결과";
    int ZERO = 0;

    static String play(String carNames, int count) {
        Cars cars = Cars.from(RacingCarGameUtil.splitName(carNames));
        OutputUtil.printLineChange();
        OutputUtil.println(GAME_RESULT_MESSAGE);
        while (count-- > ZERO) {
            cars.moveCars();
            cars.getStatus();
            OutputUtil.printLineChange();
        }
        return RacingCarGameUtil.getResult(cars.getWinner());
    }
}
