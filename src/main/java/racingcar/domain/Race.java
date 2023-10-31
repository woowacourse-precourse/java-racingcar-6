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

    private void startRace() {
        outputView.printAfterAskNumber();
        for (int i = 0; i < round; i++) {
            showProgress();
        }
    }

    private void showProgress() {
        for (Car car : carList) {
            car.moveForward();
            car.showProgress(car);
        }
        System.out.println();
    }
}
