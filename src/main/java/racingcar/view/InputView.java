package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import racingcar.error.Error;
import java.util.List;

public class InputView {
    public List<String> getInputName() {
        List<String> nameList = Arrays.asList(Console.readLine().split(","));
        Error.checkIllegalString(nameList);

        return nameList;
    }

    public int getGameTurns() {
        String turn = Console.readLine();
        Error.checkIsNumber(turn);

        return Integer.parseInt(turn);
    }
}
