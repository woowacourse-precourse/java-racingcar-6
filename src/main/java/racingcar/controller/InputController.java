package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

import static racingcar.model.nameValidator.namesException;
import static racingcar.model.roundNumberValidator.roundNumberException;
import static racingcar.view.InputView.nameInputPrint;
import static racingcar.view.InputView.roundNumberInputPrint;

public class InputController {
    public static List<String> nameInput(){
        nameInputPrint();
        String names = Console.readLine();
        List<String> nameList = namesException(names);
        return nameList;
    }

    public static int roundNumberInput(){
        roundNumberInputPrint();
        String roundNumberString = Console.readLine();
        int roundnumber = roundNumberException(roundNumberString);
        return roundnumber;
    }

}
