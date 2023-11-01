package racingcar.model;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.InputView;

import java.util.Arrays;
import java.util.List;

public class User {

    public User() {
    }

    public List<String> inputCarNames() {
        InputView.inputCarName();
        String inputCarNames = Console.readLine();
        String[] splitCarNames = inputCarNames.split(",");
        return Arrays.asList(splitCarNames);
    }
}
