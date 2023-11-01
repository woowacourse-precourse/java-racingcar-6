package racingcar.controller;

import racingcar.domain.TotalCar;
import racingcar.service.CarGame;
import racingcar.service.CarsInputManage;
import racingcar.service.FinalWinner;
import racingcar.util.InputManufacture;
import racingcar.util.Message;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameSystem {
    private TotalCar totalCar;
    private int attempt;

    public void start(InputView input, OutputView output) {
        InputManufacture manufacture = new InputManufacture();

        saveCarInputs(input, output);
        output.write(Message.TRY_MESSAGE);
        attempt = makeTryNumber(input, manufacture);
        output.write(Message.LINE);
        runGame(output);
        showWinner(output);
    }


    public int makeTryNumber(InputView input, InputManufacture manufacture) {
        String attempt = input.readTryNumber();
        return manufacture.changeIntegerNumber(attempt);
    }

    public void saveCarInputs(InputView input, OutputView output) {
        CarsInputManage carManage = new CarsInputManage();
        output.write(Message.NAME_MESSAGE);
        totalCar = carManage.makeCars(input);
    }

    public void saveTryInput(InputView input, OutputView output) {

    }

    public void runGame(OutputView output) {
        CarGame game = new CarGame(output);
        game.run(attempt, totalCar);
    }

    public void showWinner(OutputView output) {
        FinalWinner finalWinner = new FinalWinner(output);
        finalWinner.showCars(totalCar);
    }
}