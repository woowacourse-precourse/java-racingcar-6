package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import racingcar.error.Error;
import java.util.List;

public class InputView {
    public List<String> getInputNameList() {
        List<String> nameList = Arrays.asList(Console.readLine().replace(" ", "").split(","));
        Error.checkIllegalString(nameList);

        return nameList;
    }

    public int getGameTurns() {
        String turn = Console.readLine().strip();
        Error.checkIsNumber(turn);

        return Integer.parseInt(turn);
    }
}
