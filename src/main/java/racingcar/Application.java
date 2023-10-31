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
    }

    private static List<Car> createCars(RacingController racingController, InputView inputView) {
        String[] carNames = inputView.inputRacingCar();
        return racingController.createCarList(carNames);
    }

}
