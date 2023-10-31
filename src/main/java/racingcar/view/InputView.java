package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import racingcar.error.Error;
import java.util.List;

public class InputView {
    private int turns = Integer.MIN_VALUE;
    private static final int ZERO = 0;

    public void getInputTurns() {
        OutputView.printTurnHelp();
        String turn = Console.readLine().strip();
        Error.checkIsNumber(turn);

        turns = Integer.parseInt(turn);
    }

    public List<String> getInputNameList() {
        OutputView.printNameHelp();
        List<String> nameList = Arrays.asList(Console.readLine().replace(" ", "").split(","));
        Error.checkIllegalString(nameList);

        return nameList;
    }

    public boolean checkTurnOver() {
        return (turns--) != ZERO;
    }
}
