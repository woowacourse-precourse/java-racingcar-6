package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.model.AttemptCountValidator;
import racingcar.model.CarNameValidator;
import racingcar.model.RealRandomGenerator;
import racingcar.view.InputView;
import racingcar.view.RacingAttemptInput;

public class RacingController {

    private InputView inputView;
    private RacingGame racingGame;

    public RacingController(InputView inputView) {
        this.inputView = inputView;
    }

    public void playRacingGame() {
        // 사용자로부터 자동차 이름을 받기
        inputView.requestCarNames();
        String carNamesInput = inputView.getUserCarNames();
        List<String> carNames = inputView.parseCarNames(carNamesInput);
        CarNameValidator.validateCarNames(carNames);

        // 사용자로부터 시도할 횟수 받기
        RacingAttemptInput attemptInput = new RacingAttemptInput();
        attemptInput.requestAttemptCount();
        int attemptCount = attemptInput.getAttemptCount();
        AttemptCountValidator.validateIsPositive(attemptCount);

        // 게임 초기화
        racingGame = new RacingGame(carNames, new RealRandomGenerator());

        // 게임 실행 로직
        for (int i = 0; i < attemptCount; i++) {
            racingGame.race();
            printRaceResults(racingGame.getCars());
        }

        racingGame.printWinners();
    }

    private void printRaceResults(List<Car> cars) {
        cars.forEach(car -> System.out.println(car.display()));
        System.out.println();
    }
}


