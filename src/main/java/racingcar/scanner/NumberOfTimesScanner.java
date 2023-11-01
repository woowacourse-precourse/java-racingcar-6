package racingcar.scanner;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.Validator;

public class NumberOfTimesScanner implements GameScanner<Integer> {

    private final Validator<String> validator;

    public NumberOfTimesScanner(Validator<String> validator) {
        this.validator = validator;
    }

    @Override
    public Integer scan() {
        String input = Console.readLine();
        validator.validate(input);

        return Integer.parseInt(input);
    }
}
