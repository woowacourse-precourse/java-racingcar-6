package racingcar.view;

import java.util.List;

import static racingcar.util.Utils.formatListToString;

public class OutputView {

    public void printWinner(List<String> winners) {
        System.out.print("최종 우승자 : " + formatListToString(winners));
    }

}
