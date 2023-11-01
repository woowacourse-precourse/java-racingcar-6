package racingcar.view.Output;

import static racingcar.util.PrintMessage.FINAL_WINNER;
import static racingcar.util.PrintMessage.RACE_REULT;

public class OutputView {
    public void printResult() {
        System.out.println(RACE_REULT);
    }

    public void printWinner(String winner) {
        System.out.println(String.format("%s%s",FINAL_WINNER ,winner));
    }

    public void printResultFormat(String carName, String dashes) {
        System.out.println(carName + " : " + dashes);
    }
}
