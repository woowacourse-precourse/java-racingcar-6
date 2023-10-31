package racingcar;

import racingcar.controller.RacingController;
import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        RacingController racingController = new RacingController();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        List<Car> cars = createCars(racingController, inputView);

        playRacing(racingController, inputView, outputView, cars);
    }

    private static List<Car> createCars(RacingController racingController, InputView inputView) {
        String[] carNames = inputView.inputRacingCar();
        return racingController.createCarList(carNames);
    }

    private static void playRacing(RacingController racingController, InputView inputView, OutputView outputView, List<Car> cars) {
        int tryCount = inputView.inputTryCount();
        outputView.printResultMessage();
        while (tryCount --> 0) {
            Map<String, Integer> result = racingController.playRacing(cars);
            outputView.printRaceStatus(result);
        }
    }

}
