package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class Parser {
    public List<String> parseCarNames(String userInput) {
        try {
            if (userInput.isEmpty()) {
                throw new IllegalArgumentException();
            }

            String[] carNameArray = userInput.split(",");
            return Arrays.asList(carNameArray);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public int parseRoundNumber(String userInput) {
        try {
            if (userInput.isEmpty()) {
                throw new IllegalArgumentException();
            }

            return Integer.parseInt(userInput);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
