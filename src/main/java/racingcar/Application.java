package racingcar;

import racingcar.controller.RacingController;
import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        RacingController racingController = new RacingController();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        List<Car> cars = createCars(racingController, inputView);

        playRacing(racingController, inputView, outputView, cars);
        resultRacing(racingController, outputView, cars);
    }

    private static List<Car> createCars(RacingController racingController, InputView inputView) {
        String[] carNames = inputView.inputRacingCar();
        return racingController.createCarList(carNames);
    }

    private static void playRacing(RacingController racingController, InputView inputView, OutputView outputView, List<Car> cars) {
        int tryCount = inputView.inputTryCount();
        outputView.printResultMessage();
        while (tryCount-- > 0) {
            List<Car> singleRoundResult = racingController.playSingleRound(cars);
            outputView.printRaceStatus(singleRoundResult);
        }
    }

    private static void resultRacing(RacingController racingController, OutputView outputView, List<Car> cars) {
        List<String> victoryPlayers = racingController.readVictoryPlayers(cars);
        outputView.printVictoryPlayers(victoryPlayers);
    }
}
