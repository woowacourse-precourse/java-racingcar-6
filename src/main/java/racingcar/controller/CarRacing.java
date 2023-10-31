package racingcar.controller;

import racingcar.util.InputHandler;
import racingcar.domain.Cars;
import racingcar.view.View;

public class CarRacing {

    public void run() {
        View view = new View();
        InputHandler handler = new InputHandler();

        view.inputNamesMsg();
        Cars cars = handler.inputName();
        view.inputRoundMsg();
        int numberOfRound = handler.inputRound();

        view.resultTitleMsg();
        cars.roundStatus(numberOfRound);

        view.finalWinnerMsg(cars.findWinners());
    }
}
