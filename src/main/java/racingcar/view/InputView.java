package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    public List<String> userInputName() {
        OutputView.printGameStartMessage();
        String userInput = Console.readLine();

        String[] splitArr = userInput.split(",");
        List<String> nameList = Arrays.asList(splitArr);

        return nameList;
    }

    public int userInputCount() {
        OutputView.printInputNumberMessage();
        String userInput = Console.readLine();

        int count = Integer.parseInt(userInput);
        return count;
    }

}
