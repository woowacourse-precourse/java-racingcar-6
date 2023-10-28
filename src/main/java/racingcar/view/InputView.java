package racingcar.view;

import static racingcar.message.MessageConstants.INPUT_CAR_NAME_MESSAGE;
import static racingcar.message.MessageConstants.INPUT_TRYCOUNT_MESSAGE;
import static racingcar.message.MessageConstants.REGEX;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public List<String> inputCarName() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        String inputCarName = Console.readLine();
        String[] nameSplit = inputCarName.split(REGEX);
        
        return Arrays.asList(nameSplit);
    }

    public int inputTryCount() {
        System.out.println(INPUT_TRYCOUNT_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }

}
