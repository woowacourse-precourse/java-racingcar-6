package racingcar.view;


import racingcar.util.Validator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private final Validator validator = new Validator();


    public String inputTrialNumber(){
        OutputView.requestTrialNumberMessage();
        String userInput = readLine();
        return userInput;
        //validator.isValidTrialNumber(userInput);
    }

    public String inputCarName(){
        OutputView.requestCarNameMessage();
        String userInput = readLine();
        return userInput;
        //validator.isValidCarName(userInput);
    }


}
