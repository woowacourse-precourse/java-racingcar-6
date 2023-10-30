package racingcar.view;

import racingcar.ResultStringBuilder;

import java.util.HashMap;

public class OutputView {
    private static final String RACE_RESULT_MESSAGE = "실행 결과";

    ResultStringBuilder resultStringBuilder;

    public OutputView() {
        this.resultStringBuilder = new ResultStringBuilder();
    }

    public void readOngoingResultMessage() {
        System.out.println(RACE_RESULT_MESSAGE);
    }

    public void readOngoingResult(HashMap<String,Integer> result) {
        System.out.println(resultStringBuilder.stringBuild(result));
    }


}
