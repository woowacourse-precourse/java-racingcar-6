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
    public void play() {
        String carNamesInput = InputView.inputCarName();
        String trialCountInput = InputView.inputRaceGameCount();

        try {
            List<String> carNames = CarNameValidator.validateCarNames(carNamesInput);
            int trialCount = TrialCountValidator.validateTrialCount(trialCountInput);

            Cars cars = new Cars(carNames);
            Race race = new Race(cars.getCarList(), trialCount);

            for (int i = 0; i < trialCount; i++) {
                RacingCarService racingCarService = new RacingCarService();
                racingCarService.playRace(race);

                OutputView.gameResultMessage();
                for (Car car : race.getCars()) {
                    OutputView.printMovementCount(car.getCarName(), car.getCarPosition());
                }

                List<String> winners = racingCarService.selectWinners(race);
                OutputView.printSelectWinner(winners);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("오류: " + e.getMessage());
        }
    }
}
