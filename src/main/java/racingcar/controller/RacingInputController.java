package racingcar.controller;

import static racingcar.Utils.parseCarName;

import java.util.List;
import racingcar.domain.RacingCars;
import racingcar.domain.validator.CarNameValidator;
import racingcar.domain.validator.TryCountValidator;
import racingcar.view.RacingInputView;

public class RacingInputController {

    private final RacingInputView racingInputView = new RacingInputView();

    public RacingCars createRacingCars() {
        List<String> carNames = parseCarName(racingInputView.inputCarName());

        CarNameValidator carNameValidator = new CarNameValidator(carNames);
        carNameValidator.validateAll();

        return new RacingCars(carNames);
    }

    public int createTryCount() {
        final String tryCount = racingInputView.inputTryCount();

        TryCountValidator tryCountValidator = new TryCountValidator(tryCount);
        tryCountValidator.validateAll();

        return Integer.parseInt(tryCount);
    }

}
