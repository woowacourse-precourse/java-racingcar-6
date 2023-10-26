package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import racingcar.util.Convert;

public class InputView {

    public List<String> readCarNames() {
        String inputValue = readLine();
        return Convert.stringToList(inputValue);
    }
}
