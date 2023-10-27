package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarGame;
import racingcar.util.ValidInput;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {

    public void run(){
        String carNames = InputView.inputCarNames();
        ValidInput.validCarNameLength(carNames);

        String gameCountStr = InputView.inputRacingCount();
        ValidInput.validOnlyNumber(gameCountStr);
        int gameCount = Integer.parseInt(gameCountStr);

        CarGame carGame = new CarGame(carNames,gameCount);

        OutputView.printResult();
        for(int i = 0;i<gameCount;i++){
            carGame.movePosition();
            OutputView.printPosition(carGame.getCars());
        }

        List<Car> winner = carGame.findWinner();
        OutputView.printWinner(winner);
    }
}
