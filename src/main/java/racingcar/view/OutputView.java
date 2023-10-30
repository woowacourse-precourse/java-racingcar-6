package racingcar.view;

import racingcar.model.RaceResult;

public class OutputView {

    private static final String ROUND_PROGRESS = "실행 결과\n";
    private static final String FINAL_WINNER = "최종 우승자 : ";

    public void printRoundResult(String roundResult) {
        System.out.println(ROUND_PROGRESS + roundResult);
    }

    public void printResult(RaceResult result) {
        System.out.println(FINAL_WINNER + result.toString());
    }
}
