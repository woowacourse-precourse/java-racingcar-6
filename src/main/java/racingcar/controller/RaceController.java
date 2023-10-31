package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.NumberGenerator;
import racingcar.domain.Referee;
import racingcar.util.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private final InputView inputView;
    private final OutputView outputView;

    public RaceController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<String> carNames = inputView.askCarNames();
        List<Car> cars = createCars(carNames);

        int moveCount = inputView.askMoveCount();

        System.out.println("\n실행 결과");
        repeatMoveCars(moveCount, cars);

        Referee referee = new Referee(cars);
        List<Car> winners = referee.findWinners();

        outputView.showWinners(winners);
    }

    public void tryMoveCars(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = NumberGenerator.generateRandomNumber();

            car.moveForward(randomNumber);
            String moveTryResult = car.expressMoveDistance();

            outputView.showMoveDistance(moveTryResult);
        }
    }

    public void repeatMoveCars(int moveCount, List<Car> cars) {
        while (moveCount-- > 0) {
            tryMoveCars(cars);
            System.out.println();
        }
    }

    public List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(carName -> new Car(carName.trim()))
                .collect(Collectors.toList());
    }
}
