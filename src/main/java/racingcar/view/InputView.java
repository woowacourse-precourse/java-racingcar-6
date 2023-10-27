package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.util.InputDataValidator.validateHasSpace;
import static racingcar.util.InputDataValidator.validateInputSize;
import static racingcar.util.InputDataValidator.validateIsInteger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.common.Config;

public class InputView {
    String input = "";

    public List<String> inputCars() {
        List<String> carList = new ArrayList<>();

        input = readLine();

        validateHasSpace(input);

        carList = Arrays.stream(input.split(Config.SPLIT_REGEXP)).collect(Collectors.toList());

        for (String carName : carList) {
            validateInputSize(carName);
        }

        return carList;
    }

    public Integer inputCountNumber() {
        input = readLine();
        validateIsInteger(input);

        return Integer.parseInt(input);
    }
}
