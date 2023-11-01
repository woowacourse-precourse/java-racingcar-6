package racingcar.view.Output;

import static racingcar.view.PrintMessage.FINAL_WINNER;
import static racingcar.view.PrintMessage.RACE_REULT;

public class OutputView {
    // 결과 출력
    public void printResult() {
        System.out.println(RACE_REULT);
    }

    // 최종 우승자 출력
    public void printWinner(String winner) {
        System.out.println(String.format("%s%s",FINAL_WINNER ,winner));
    }
}
