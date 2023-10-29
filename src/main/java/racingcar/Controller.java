package racingcar;

import racingcar.Model.Cars;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class Controller {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Cars cars = new Cars();

    private int trialNumber;

    private void setRacing(){
        cars.addCar(inputView.printStart());
        trialNumber = inputView.printTrial();
        outputView.printResultStart();
    }
    

    private void racingResult(){
        for (int i = 0; i < cars.carsLength(); i++){
            outputView.printRacingResult(cars.getCarName(i), cars.getCarPositionIcon(i));
        }
        System.out.println();
    }
}
