package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

import static racingcar.model.NameValidator.namesException;
import static racingcar.model.RoundNumberValidator.roundNumberException;
import static racingcar.view.InputView.nameInputPrint;
import static racingcar.view.InputView.roundNumberInputPrint;

public class InputController {
    public static List<String> nameInput(){
        nameInputPrint();
        String names = Console.readLine();
        return namesException(names);
    }

    public static int roundNumberInput(){
        roundNumberInputPrint();
        String roundNumberString = Console.readLine();
        return roundNumberException(roundNumberString);
    }

}
