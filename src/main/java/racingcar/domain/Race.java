package racingcar.domain;

import java.util.List;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Race {
    private List<Car> carList;
    private int round = 0;
    OutputView outputView = new OutputView();

    public void initialRace() {
        outputView.printStartMessage();
        InputView inputView = new InputView();
        carList = Car.generate(inputView.inputName());
        outputView.askNumOfAttemptsMessage();
        round = inputView.inputRound();
        startRace();
    }

    private void duringRace() {
        for (Car car : carList) {
            car.ableMoveForward();
        }
    }

}
