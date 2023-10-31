package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.InputView;
import racingcar.util.Parser;

import java.util.List;

public class Controller {
    public void getCarNames(){
        Parser parser = new Parser();

        InputView.requestCarNaming();
        System.out.println(parser.getSplitString(Console.readLine()));
    }
}
