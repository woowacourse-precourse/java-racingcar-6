package racingcar.controller;

import static racingcar.util.Parser.parseCarName;

import java.util.List;
import racingcar.domain.RacingCars;
import racingcar.domain.validator.CarNameValidator;
import racingcar.domain.validator.TryCountValidator;
import racingcar.view.input.RacingInputView;

public class RacingInputController {

    private final RacingInputView racingInputView = new RacingInputView();

    public RacingCars createRacingCars() {
        try {
            List<String> carNames = parseCarName(racingInputView.inputCarName());

            CarNameValidator carNameValidator = new CarNameValidator(carNames);
            carNameValidator.validateAll();

            return new RacingCars(carNames);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return this.createRacingCars();
        }
    }

    public int createTryCount() {
        try {
            final String tryCount = racingInputView.inputTryCount();

            TryCountValidator tryCountValidator = new TryCountValidator(tryCount);
            tryCountValidator.validateAll();

            return Integer.parseInt(tryCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return this.createTryCount();
        }
    }

}
