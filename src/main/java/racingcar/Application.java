package racingcar;

import racingcar.controller.RacingCarGameController;
import racingcar.domain.Car;
import racingcar.model.Cars;
import racingcar.view.CarsInputView;
import racingcar.view.RoundInputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        CarsInputView carsInputView = new CarsInputView();
        RoundInputView roundInputView = new RoundInputView();

        List<Car> carList = carsInputView.generateInputList();
        Cars cars = new Cars(carList);

        int totalRoundNumber = roundInputView.generateRoundNumber();

        RacingCarGameController racingCarGameController = new RacingCarGameController();
        racingCarGameController.gameStart(totalRoundNumber,cars);

    }
}
