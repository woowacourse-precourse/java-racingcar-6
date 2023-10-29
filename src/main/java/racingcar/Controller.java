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
}
