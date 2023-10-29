package racingcar;


import racingcar.domain.Controller;
import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView.startInputMessage();
        String carName = InputView.inputCarName();
        new Car(carName);
        Controller.validateCarNames();
        OutputView.askForAttemptsCount();
        Controller.validateInputAttemptsCount();
        OutputView.resultMessage();
        OutputView.displayResult();
    }
}
