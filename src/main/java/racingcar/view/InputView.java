package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.InputValidator;

import java.util.Arrays;
import java.util.List;

public class InputView {
    InputValidator inputValidator = new InputValidator();
    public List<String> userInputName() {
        OutputView.printGameStartMessage();
        String userInput = Console.readLine();

        String[] splitArr = userInput.split(",");
        List<String> nameList = Arrays.asList(splitArr);
        for (String name: splitArr) {
            inputValidator.isValidNameLength(name);
        }
        return nameList;
    }

    public int userInputCount() {
        OutputView.printInputNumberMessage();
        String userInput = Console.readLine();
        inputValidator.isValidInteger(userInput);
        int count = Integer.parseInt(userInput);
        return count;
    }

}
