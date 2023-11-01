package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private final static String DELIMITER = ",";

    public List<String> carNameListInput() {
        String userInput = Console.readLine();

        List<String> carNameList = Arrays.asList(userInput.split(DELIMITER));
        return carNameList;
    }

}


