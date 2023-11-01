package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.CarValidator;
import racingcar.validator.TryCountValidator;

public class InputView {
    private final CarValidator carValidator = new CarValidator();
    private final TryCountValidator tryCountValidator = new TryCountValidator();
    private final static String SPLIT_SYMBOL = ",";

    public String[] inputCarNames() {
        String inputWithoutSpace = Console.readLine().replaceAll("\\s+", "");
        String[] carNames = inputWithoutSpace.split(SPLIT_SYMBOL);
        carValidator.checkInput(carNames);
        return carNames;
    }

    public int inputTryCount() {
        String tryCount = Console.readLine();
        return tryCountValidator.checkInput(tryCount);
    }
}
