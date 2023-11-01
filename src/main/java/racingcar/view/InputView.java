package racingcar.view;


import racingcar.util.Validator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {


    public String inputTrialNumber(){
        OutputView.requestTrialNumberMessage();
        String userInput = readLine();
        return userInput;
    }

    public String inputCarName(){
        OutputView.requestCarNameMessage();
        String userInput = readLine();
        return userInput;
    }


}
