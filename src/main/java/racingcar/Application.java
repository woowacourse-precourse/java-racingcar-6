package racingcar;

import racingcar.domain.Racing;
import racingcar.domain.RacingCarName;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        RacingCarName racingCarName = new RacingCarName();
        List<String> carNames = racingCarName.carNameList();

        Racing racing = new Racing();
        racing.countMoveRacing(carNames);
    }
}
