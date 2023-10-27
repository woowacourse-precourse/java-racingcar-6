package racingcar.view;

import racingcar.util.Parser;
import racingcar.util.Validator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private final Validator validator = new Validator();
    private final Parser parser = new Parser();


    private void inputTrialNumber(){
        OutputView.requestTrialNumberMessage();
        String userInput = readLine();
        validator.isValidTrialNumber(userInput);
    }

    private void inputCarName(){
        OutputView.requestCarNameMessage();
        String userInput = readLine();
        validator.isValidCarName(userInput);
    }


}
