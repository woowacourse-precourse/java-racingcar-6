package racingcar.service;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import racingcar.util.Parser;

public class InputOutputService {
    private final Parser parser = new Parser();

    public List<String> getCarName() {
        String userInput = readLine();
        return parser.parseCarNames(userInput);
    }

    public int getRoundNumber() {
        String userInput = readLine();
        return parser.parseRoundNumber(userInput);
    }
}
