package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.Converter;
import racingcar.utils.Validator;

import java.util.List;

public class InputView {
    public List<String> readCars() {
        String input = Console.readLine();
        List<String> carNames = Converter.toList(input);
        for (String name : carNames) {
            Validator.validateCarName(name);
        }
        return carNames;
    }

    public int readNumOfExecutions() throws IllegalArgumentException {
        String input = Console.readLine();
        Validator.validateDigit(input);

        int numOfExecutions = Integer.parseInt(input);
        Validator.validateRangeOfExecutions(numOfExecutions);
        return numOfExecutions;
    }
}
