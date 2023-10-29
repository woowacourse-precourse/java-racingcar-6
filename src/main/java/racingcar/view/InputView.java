package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.Service.InputException;

public class InputView {
    InputException ex = new InputException();

    public List<String> inputCarNames(){
        String userInput = Console.readLine();
        List<String> names = ex.divideCarNames(userInput);
        ex.validCarName(names);
        return names;
    }

    public int inputTryCount(){
        String userInput = Console.readLine();
        return ex.changeStringToInt(userInput);
    }
}
