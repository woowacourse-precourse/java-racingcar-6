package racingcar.service;

import java.util.Arrays;
import java.util.List;
import racingcar.util.ExceptionHandler;
import racingcar.validation.InputValidator;

public class RacingService {
    public List<String> stringToList(String input) {
        return Arrays.asList(input.split(","));
    }
}
