package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.util.InputDataValidator.validateHasSpace;
import static racingcar.util.InputDataValidator.validateInputList;
import static racingcar.util.InputDataValidator.validateIsInteger;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.common.Config;

public class InputView {
    String input = "";

    private InputView() {

    }

    public static InputView createInputView() {
        return new InputView();
    }

    public List<String> inputCars() {
        List<String> carList;

        input = readLine();

        validateHasSpace(input);

        carList = Arrays.stream(input.split(Config.SPLIT_REGEXP)).collect(Collectors.toList());

        validateInputList(carList);

        return Collections.unmodifiableList(carList);
    }

    public Integer inputCountNumber() {
        input = readLine();
        validateIsInteger(input);

        return Integer.parseInt(input);
    }
}
