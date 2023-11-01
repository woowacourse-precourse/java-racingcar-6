package racingcar.view;

import racingcar.ResultStringBuilder;

import java.util.Map;

public class OutputView {
    private static final String RACE_RESULT_MESSAGE = "실행 결과";
    private static final String RACE_WINNER_MESSAGE = "최종 우승자 : ";

    ResultStringBuilder resultStringBuilder;

    public OutputView() {
        this.resultStringBuilder = new ResultStringBuilder();
    }

    public void readOngoingResultMessage() {
        System.out.println(RACE_RESULT_MESSAGE);
    }

    public void readOngoingResult(Map<String,Integer> result) {
        System.out.println(resultStringBuilder.stringBuild(result));
    }

    public void readWinner(String winners) {
        if (winners==null) {
            System.out.println(RACE_WINNER_MESSAGE+"없음");
        } else {
            System.out.println(RACE_WINNER_MESSAGE+winners);
        }
    }
}
