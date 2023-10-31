package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.InputView;
import racingcar.view.outputView;
import racingcar.util.Parser;

import java.util.List;

public class Controller {
    List<String> carNames;
    Parser parser;

    public void testRun(){
        parser = new Parser();

        outputView.printRacingResult(getCarNames(), getRacingRound());
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
