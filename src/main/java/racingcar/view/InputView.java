package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.constant.Constant;

public class InputView {
    public List<String> getCarNamesFromUser() {
        String userInput = Console.readLine();
        String[] carNames = userInput.split(Constant.INPUT_CAR_NAMES_DELIMITER);
        return Arrays.asList(carNames);
    }

    public Integer getNumberOfGamesFromUser() {
        String userInput = Console.readLine();
        return Integer.parseInt(userInput);
    }
}
