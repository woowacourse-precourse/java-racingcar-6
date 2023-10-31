package racingcar.view;

import static racingcar.utility.Constants.EXECUTION_RESULT;

public class OutputView {
    private static final OutputView outputView = new OutputView();

    private OutputView(){}

    public static OutputView getInstance(){
        return outputView;
    }

    public void printExecutionResultMessage(){
        System.out.println(EXECUTION_RESULT);
    }
}
