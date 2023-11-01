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

public class RacingCarController {

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
                racingCarService.playAndSelectWinners(race);

                // 각 자동차의 이동 출력
                OutputView.gameResultMessage();
                for (Car car : race.getCars()) {
                    OutputView.printMovementIndicator(car.getCarName(), car.getCarPosition());
                }
            }

        } catch (IllegalArgumentException e) {
            System.out.println("오류: " + e.getMessage());
        }
    }
}
