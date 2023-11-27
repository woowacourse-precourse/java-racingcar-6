package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.view.input.parser.InputParser;

public class InputView {
    private final InputParser inputParser;

    public InputView() {
        inputParser = new InputParser();
    }

    public List<String> getCarNames() {
        return inputParser.parseToCarNames(readLine());
    }

    public int getTrialTimes() {
        return inputParser.parseToTrialTimes(readLine());
    }

    private String readLine() {
        return Console.readLine();
    }
}