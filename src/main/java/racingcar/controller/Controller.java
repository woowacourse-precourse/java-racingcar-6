package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.InputView;

public class Controller {

    private String getCarNameByUserInput(){
        InputView.requestCarNamesMessage();
        String input = Console.readLine();
        return checkValidateCarName(input);
    }
}
