package racingcar.domain;

import java.util.List;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Race {
    private List<Car> carList;
    private int round = 0;
    private boolean isRacing = true;
    OutputView outputView = new OutputView();

    public void raceStart() {
        InputView inputView = new InputView();
        carList = Car.generate(inputView.inputName());
        outputView.printStartMessage();
        outputView.askNumOfAttemptsMessage();
        round = inputView.inputRound();
    }

    private void duringRace() {
        for (Car car : carList) {
            car.ableMoveForward();
        }
    }

}
