package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;

import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.view.ResultView;
import racingcar.view.SettingView;
import racingcar.utils.Validator;

public class GameController {
    private final Game game = new Game();
    private static final GameController INSTANCE = new GameController();

    private GameController() {
    }

    public static GameController getInstance() {
        return INSTANCE;
    }

    public void setGame() {
        setCars();
        setRoundNumber();
        System.out.println();
    }

    public void printResults() {
        ResultView.printResultTitle();
        for (int r = 0; r < game.round; r++) {
            printResultOfRound();
        }
    }

    public void printWinner() {
        computeWinners();
        ResultView.printWinner(game.getWinners());
    }

    public void setCars() {
        SettingView.printInputCarNameMsg();
        String carNamesInputString = Console.readLine();
        setCarList(carNamesInputString);
    }

    public void setRoundNumber() {
        SettingView.printInputRoundNumberMsg();
        String roundInputString = Console.readLine();
        Validator.checkRoundValidation(roundInputString);
        game.round = Integer.parseInt(roundInputString);
    }

    public void printResultOfRound() {
        for (Car car : game.carList) {
            car.moveOrStay();
            ResultView.printCarState(car.name, car.score);
        }
        System.out.println();
    }

    public void computeWinners() {
        for (Car car : game.carList) {
            game.updateWinners(car);
        }
    }

    public void setCarList(String carNamesInputString) {
        for (String carName : carNamesInputString.split(",",-1)) {
            Validator.checkCarNameValidation(carName);
            game.updateCar(new Car(carName));
        }
    }
}
