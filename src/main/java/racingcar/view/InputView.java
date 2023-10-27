package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.util.InputParser;

public class InputView {
    private final InputParser inputParser = new InputParser();

    public List<String> inputCars() {
        String input = Console.readLine();
        return inputParser.carsParser(input);
    }
}
