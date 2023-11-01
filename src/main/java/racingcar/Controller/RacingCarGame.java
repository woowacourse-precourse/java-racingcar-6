package racingcar.Controller;

import java.util.List;
import racingcar.Domain.Cars;
import racingcar.Domain.Race;
import racingcar.Validator.CarNameValidator;
import racingcar.Validator.TrialCountValidator;
import racingcar.View.InputView;

public class RacingCarController {

    public void play() {
        String carNamesInput = InputView.inputCarName();
        String trialCountInput = InputView.inputRaceGameCount();

        try {
            List<String> carNames = CarNameValidator.validateCarNames(carNamesInput);
            int trialCount = TrialCountValidator.validateTrialCount(trialCountInput);

            Cars cars = new Cars(carNames);
            Race race = new Race(cars.getCarList(), trialCount);


        } catch (IllegalArgumentException e) {
            System.out.println("오류: " + e.getMessage());
        }
    }
}
