package racingcar.scanner;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.validator.Validator;

public class RacingCarNameScanner implements GameScanner<List<String>> {

    private final Validator<List<String>> validator;

    public RacingCarNameScanner(Validator<List<String>> validator) {
        this.validator = validator;
    }

    @Override
    public List<String> scan() {
        List<String> racingCarNames = Arrays.stream(Console.readLine().split(","))
                .map(String::strip)
                .collect(Collectors.toList());

        validator.validate(racingCarNames);

        return racingCarNames;
    }
}
