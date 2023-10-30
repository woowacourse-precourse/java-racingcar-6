package racingcar;

import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.NumberOfAttempts;
import racingcar.domain.Referee;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final NumberGenerator numberGenerator;

    public GameController(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        // 경주할 자동차 생성
        List<String> carNames = InputView.readCarNames();
        Cars cars = createCars(carNames);

        // 시도 횟수 입력
        NumberOfAttempts numberOfAttempts = new NumberOfAttempts(InputView.readNumberOfAttempts());

        // 게임 진행
        OutputView.printRacingResultMessage();
        while (numberOfAttempts.hasRemainingAttempts()) {
            MoveResult moveResult = cars.move(numberGenerator);
            OutputView.printMoveResult(moveResult);
            numberOfAttempts.decreaseNumberOfAttempts();
        }
        List<String> winners = decideWinners(cars);
        OutputView.printWinners(winners);
    }

    private Cars createCars(List<String> carNames) {
        return new Cars(carNames.stream()
                .map(Car::new)
                .toList());
    }

    private List<String> decideWinners(Cars cars) {
        Referee referee = new Referee();
        return referee.decideWinners(cars)
                .stream()
                .map(Car::getName)
                .toList();
    }
}
