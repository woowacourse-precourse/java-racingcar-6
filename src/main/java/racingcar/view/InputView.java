package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.Converter;
import racingcar.utils.Validator;

import java.util.List;

public class InputView {
    public List<String> readCars() {
        String input = Console.readLine();
        return Converter.toList(input);
    }

    public int readNumOfExecutions() throws IllegalArgumentException {
        String input = Console.readLine();
        Validator.validateDigit(input);

        int numOfExecutions = Integer.parseInt(input);
        Validator.validateRangeOfExecutions(numOfExecutions);
        return numOfExecutions;
    }
}
