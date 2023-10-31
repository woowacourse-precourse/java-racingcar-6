package racingcar.view.input;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputViewImpl implements InputView {

    private final Validator validator;

    public InputViewImpl(Validator validator) {
        this.validator = validator;
    }

    @Override
    public List<String> inputCarNames() {
        List<String> carNames = Arrays.asList(Console.readLine().split(","));
        carNames.forEach((carName) -> validator.validateCarName(carName));
        return carNames;
    }

    @Override
    public int inputRetryCount() {
        return Integer.parseInt(Console.readLine());
    }
}
