package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.TotalCar;
import racingcar.service.CarGame;
import racingcar.service.FinalWinner;
import racingcar.util.InputManufacture;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameSystem {
    private TotalCar totalCar;
    private int attempt;

    public void start(InputView input, OutputView output) {
        InputManufacture manufacture = new InputManufacture();
        output.askName();
        totalCar = makeCars(input, manufacture);
        output.askTry();
        attempt = makeTryNumber(input, manufacture);
        output.showLine();
        runGame(output);
        showWinner(output);
    }

    public TotalCar makeCars(InputView input, InputManufacture manufacture) {
        List<String> nameList = makeCarNames(input, manufacture);
        return saveCarList(nameList);
    }

    public ArrayList<String> makeCarNames(InputView input, InputManufacture manufacture) {
        String names = input.readCarNames();
        return manufacture.makeNameList(names);
    }

    public TotalCar saveCarList(List<String> nameList) {
        TotalCar totalCar = new TotalCar();

        for (String name : nameList) {
            totalCar.saveNewCar(name);
        }
        return totalCar;
    }

    public int makeTryNumber(InputView input, InputManufacture manufacture) {
        String attempt = input.readTryNumber();
        return manufacture.changeIntegerNumber(attempt);
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