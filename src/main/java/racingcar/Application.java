package racingcar;

import racingcar.controller.RacingCarGameController;
import racingcar.domain.Car;
import racingcar.model.Cars;
import racingcar.view.CarsInputView;
import racingcar.view.OutputView;
import racingcar.view.RoundInputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        CarsInputView carsInputView = new CarsInputView();
        List<Car> carList = carsInputView.generateInputList();
        Cars cars = new Cars(carList);

        RoundInputView roundInputView = new RoundInputView();
        int totalRoundNumber = roundInputView.generateRoundNumber();

        OutputView outputView = new OutputView();
        outputView.printStartMessage();

        RacingCarGameController racingCarGameController = new RacingCarGameController();
        for(int i=0;i<totalRoundNumber;++i){
            racingCarGameController.fowardCars(cars);
            outputView.printRoundResult(cars);
        }

        int maxStepValue = racingCarGameController.getMaxStep(cars);
        outputView.printFinalResult(cars,maxStepValue);
    }
}
