package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.model.AttemptCountValidator;
import racingcar.model.CarNameValidator;
import racingcar.model.RealRandomGenerator;
import racingcar.view.CarNameInput;
import racingcar.view.RacingAttemptInput;

public class RacingController {

    private CarNameInput carNameInput;
    private RacingGame racingGame;

    public RacingController(CarNameInput carNameInput) {
        this.carNameInput = carNameInput;
    }

    public void playRacingGame() {
        // 사용자로부터 자동차 이름을 받기
        carNameInput.requestCarNames();
        String carNamesInput = carNameInput.getUserCarNames();
        List<String> carNames = carNameInput.parseCarNames(carNamesInput);
        CarNameValidator.validateCarNames(carNames);

        // 사용자로부터 시도할 횟수 받기
        RacingAttemptInput attemptInput = new RacingAttemptInput();
        attemptInput.requestAttemptCount();
        String input = attemptInput.readUserInput();
        int attemptCount = AttemptCountValidator.validateAttemptCount(input);

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


