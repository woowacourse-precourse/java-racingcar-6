package racingcar;

import racingcar.controller.Race;
import racingcar.domain.Cars;
import racingcar.domain.MoveCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView.printRacingStart();
        Cars cars = new Cars(InputView.getCarNames());

        OutputView.printAskCount();
        MoveCount moveCnt = Race.inputMoveCount();

        Race race = new Race(cars, moveCnt);
        race.run();
    }
}
