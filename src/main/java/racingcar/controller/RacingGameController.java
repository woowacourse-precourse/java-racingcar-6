package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.RoundCount;
import racingcar.domain.car.Car;
import racingcar.domain.power.DefaultPowerGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void runRacingGame() {
        List<Car> cars = prepareRacingCars();
        RoundCount roundCount = setRoundNumber();

        System.out.println("실행 결과");

        while (roundCount.hasNextRound()) {
            executeRound(cars);
            roundCount.consumeRound();
        }
        outputView.showGameResult(cars);

    }

    private void executeRound(List<Car> cars) {
        for (Car car : cars) {
            car.tryDrive();
        }
        outputView.showRoundResult(cars);
    }

    private RoundCount setRoundNumber() {
        RoundCount roundCount = inputView.readNumberOfRounds();
        return roundCount;
    }

    private List<Car> prepareRacingCars() {
        List<String> carNames = inputView.readCarNames();
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName, 0, new DefaultPowerGenerator()));
        }
        return cars;
    }
}
