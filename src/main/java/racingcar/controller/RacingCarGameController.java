package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarGameController {
    Game game = new Game();
    Cars cars = new Cars();

    public void start() {
        String nameData = InputView.askName();
        List<String> name = List.of(nameData.replace(" ", "").split(","));
        for(String carName : name) {
            cars.add(new Car(carName));
        }

        String TryNumberData = InputView.askTryNumber();
        game.setTryNumber(TryNumberData);
    }

    public void inProgress() {
        OutputView.displayResult();
    }

    public void end() {
        OutputView.displayWinner();
    }
}
