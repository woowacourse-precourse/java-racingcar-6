package racingcar.service;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import racingcar.view.TextInterface;

public class RacingcarGameService {
    private int roundTimes;

    public List<String> getCarNames() {
        String userInput = readLine();
        return parseCarNames(userInput);
    }

    public void getRoundNumber() {
        String userInput = readLine();
        roundTimes = parseRoundNumber(userInput);
    }

    public int getRoundTimes() {
        return roundTimes;
    }

    private List<String> parseCarNames(String userInput) {
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

    private int parseRoundNumber(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
