package racingcar.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.validation.CarNameValidation;
import racingcar.validation.TryCountValidation;

public class InputView {
    private final CarNameValidation carNameValidation;
    private final TryCountValidation tryCountValidation;

    public InputView(CarNameValidation carNameValidation, TryCountValidation tryCountValidation) {
        this.carNameValidation = carNameValidation;
        this.tryCountValidation = tryCountValidation;
    }

    public List<String> inputCarName() {
        String carName = Console.readLine();
        carNameValidation.isNullOrEmpty(carName);
        carNameValidation.checkCommaError(carName);
        List<String> carNames = carNameValidation.checkDuplicate(carName);
        return carNameValidation.checkCarNameLength(carNames);
    }

    public int inputTryCount() {
        String inputTryCount = Console.readLine();
        tryCountValidation.isNullOrEmpty(inputTryCount);
        int tryCount = tryCountValidation.isInteger(inputTryCount);
        return tryCountValidation.isMoreThanOne(tryCount);
    }
}
