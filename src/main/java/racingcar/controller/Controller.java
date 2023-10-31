package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.InputView;
import racingcar.util.Parser;

import java.util.List;

public class Controller {
    List<String> carNames;
    Parser parser;

    public void testRun(){
        parser = new Parser();

        System.out.println(getCarNames());
        System.out.println(getRacingRound());
    }

    private int getRacingRound(){
        InputView.requestRacingRoundNumber();
        return parser.changeStringToInteger(Console.readLine());
    }

    private List<String> getCarNames(){
        InputView.requestCarNaming();
        return parser.getSplitString(Console.readLine());
    }
}
