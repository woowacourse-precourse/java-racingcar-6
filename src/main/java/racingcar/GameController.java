package racingcar;

import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.MoveResult;
import racingcar.domain.Referee;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final RandomNumberGenerator numberGenerator;

    public GameController(RandomNumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        // 경주할 자동차 생성
        List<String> carNames = InputView.readCarNames();
        Cars cars = createCars(carNames);

        // 시도 횟수 입력
        int numberOfAttempts = InputView.readNumberOfAttempts();
        if (!(1 <= numberOfAttempts && numberOfAttempts <= 100)) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 1 이상 100 이하만 가능합니다.");
        }

        // 게임 진행
        OutputView.printRacingResultMessage();
        while (numberOfAttempts > 0) {
            MoveResult moveResult = cars.moveForward(numberGenerator);
            OutputView.printRacingResult(moveResult.getCarNames(), moveResult.getForwardCounts());
            numberOfAttempts--;
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
