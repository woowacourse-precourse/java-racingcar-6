package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.power.DefaultPowerGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {

    private final InputView inputView;
    private final OutputView outputView;
    private final Referee referee;

    public RacingGame(InputView inputView, OutputView outputView, Referee referee) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.referee = referee;
    }

    public void run() {
        List<Car> cars = prepareRacingCars();
        RoundCount roundCount = setRoundNumber();

        System.out.println("\n실행 결과");

        while (roundCount.hasNextRound()) {
            executeRound(cars);
            roundCount.consumeRound();
        }
        List<Car> winners = referee.selectWinners(cars);
        outputView.showGameResult(winners);
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
