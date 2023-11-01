package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.model.nameValidator.namesException;
import static racingcar.view.InputView.nameInputPrint;

public class InputController {
    public static void nameInput(){
        nameInputPrint();
        String names = Console.readLine();
        namesException(names);
    }

}
