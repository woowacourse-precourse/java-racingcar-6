package racingcar.service;

import java.util.Arrays;
import java.util.List;

public class RacingService {
    public List<String> stringToList(String input) {
        return Arrays.asList(input.split(","));
    }
}
