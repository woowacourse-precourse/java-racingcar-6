package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    public List<String> askForCarNames() {
        String userInput = Console.readLine();
        return List.of(userInput.split(","));
    }

    public int askForNumberOfRounds() {
        String userInput = Console.readLine();
        return Integer.parseInt(userInput);
    }
}
