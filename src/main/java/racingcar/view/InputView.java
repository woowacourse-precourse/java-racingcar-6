package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.InputException;

import java.util.List;

public class InputView {
    InputException exceptionInstance = InputException.getinstance();

    public InputView() {
    }

    public List<String> carListInput() {
        String input = Console.readLine();
        List<String> carList = exceptionInstance.carListException(input);
        return carList;
    }

    public int numOfRoundInput() {
        String input = Console.readLine();
        int numOfRound = exceptionInstance.RoundException(input);
        return numOfRound;
    }
}
