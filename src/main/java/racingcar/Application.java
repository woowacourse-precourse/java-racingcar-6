package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.RacingCarInputManager;
import racingcar.domain.RacingCarOutputManager;

public class Application {
    public static void main(String[] args) {
        RacingCarInputManager inputManager = new RacingCarInputManager();
        RacingCarOutputManager outputManager = new RacingCarOutputManager();

        outputManager.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Cars cars = new Cars(inputManager.readCarNames());

    }
}
