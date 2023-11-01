package racingcar.controller;

import racingcar.domain.TotalCar;
import racingcar.service.CarGame;
import racingcar.service.CarsInputManage;
import racingcar.service.FinalWinner;
import racingcar.service.TryInputManage;
import racingcar.util.Message;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameSystem {
    private TotalCar totalCar;
    private int attempt;

    public void start(InputView input, OutputView output) {
        saveCarInputs(input, output);
        saveTryInput(input, output);
        runGame(output);
        showWinner(output);
    }

    private void saveCarInputs(InputView input, OutputView output) {
        CarsInputManage carManage = new CarsInputManage();
        output.write(Message.NAME_MESSAGE);
        totalCar = carManage.makeCars(input);
    }

    private void saveTryInput(InputView input, OutputView output) {
        TryInputManage tryManage = new TryInputManage();
        output.write(Message.TRY_MESSAGE);
        output.write(Message.LINE);
        attempt = tryManage.makeTryNumber(input);
        output.write(Message.LINE);
    }

    private void runGame(OutputView output) {
        CarGame game = new CarGame(output);
        game.run(attempt, totalCar);
    }

    private void showWinner(OutputView output) {
        FinalWinner finalWinner = new FinalWinner(output);
        finalWinner.showCars(totalCar);
    }
}