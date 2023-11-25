package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Rounds;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    InputView inputView = new InputView();

    public void init() {
        Cars cars = enrollCars();
        Rounds rounds = enrollCounts();
        race(cars, rounds);
    }

    public Cars enrollCars() {
        OutputView.printRequestInputCars();
        return inputView.getCarsInput();
    }

    public Rounds enrollCounts() {
        OutputView.printRequestInputRounds();
        return inputView.getRoundsInput();
    }

    public void race(Cars cars, Rounds rounds) {
        int currentRound = 0;
        OutputView.printResultMessage();
        while (rounds.isNotOver(currentRound++)) {
            cars.moveCars();
            OutputView.printCarsStatus(cars.getCars());
        }
        printWinners(cars);
    }

    private void printWinners(Cars cars) {
        int maxPosition = cars.getMaxPosition();
        List<Car> winners = cars.getWinners(maxPosition);
        StringBuilder winnerNames = new StringBuilder();
        for (Car winner : winners) {
            if (winnerNames.length() > 0) {
                winnerNames.append(", ");
            }
            winnerNames.append(winner.getName());
        }
        System.out.println("최종 우승자 : " + winnerNames.toString());
    }
}
