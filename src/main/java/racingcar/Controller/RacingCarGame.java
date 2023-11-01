package racingcar.Controller;

import java.util.List;
import racingcar.Domain.Car;
import racingcar.Domain.Cars;
import racingcar.Domain.Race;
import racingcar.Service.RacingCarService;
import racingcar.Validator.CarNameValidator;
import racingcar.Validator.TrialCountValidator;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class RacingCarGame {
    private final RacingCarService racingCarService = new RacingCarService();

    public void play() {
        String carNamesInput = InputView.inputCarName();
        String trialCountInput = InputView.inputRaceGameCount();

        // 유효성 검증
        List<String> carNames = validateCarNames(carNamesInput);
        int trialCount = validateTrialCount(trialCountInput);

        // 객체 생성
        Cars cars = new Cars(String.join(", ", carNames));
        Race race = new Race(cars.getCarList(), trialCount);

        // 게임 실행
        playGame(race);

        // 우승자 선정
        selectAndPrintWinners(race);
    }

    private void playGame(Race race) {
        int trialCount = race.getTrialCount();
        for (int i = 0; i < trialCount; i++) {
            racingCarService.playRace(race);
            printGameResult(race);
        }
    }

    private void printGameResult(Race race) {
        OutputView.gameResultMessage();
        for (Car car : race.getCars()) {
            OutputView.printMovementCount(car.getCarName(), car.getCarPosition());
        }
    }

    private void selectAndPrintWinners(Race race) {
        List<String> winners = racingCarService.selectWinners(race);

        OutputView.printSelectWinner(winners);
    }

    private List<String> validateCarNames(String carNamesInput) {
        List<String> carNames = CarNameValidator.validateCarNames(carNamesInput);
        if (carNames == null) {
            throw new IllegalArgumentException("유효하지 않은 차 이름입니다.");
        }
        return carNames;
    }

    private int validateTrialCount(String trialCountInput) {
        int trialCount = TrialCountValidator.validateTrialCount(trialCountInput);
        if (trialCount < 0) {
            throw new IllegalArgumentException("유효하지 않은 시도 횟수입니다.");
        }
        return trialCount;
    }

}
