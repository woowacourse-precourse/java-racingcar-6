package racingcar.controller;

import racingcar.domain.CarMoveCondition;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutPutView;

public class GameStartController {

    public void gameStart() {

        Cars cars = new Cars(InputView.startGame());

        int count = InputView.startGameCount();

        System.out.println();

        while (count != 0) {

            cars.carMove(new CarMoveCondition());
            OutPutView.outPutViewResult(cars);

            count--;
        }

        OutPutView.outPutViewWinners(cars.winners());
    }

}
