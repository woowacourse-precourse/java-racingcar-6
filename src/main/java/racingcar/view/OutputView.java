package racingcar.view;

import java.util.List;

public class OutputView {
    public void printWinners(List<String> winners) {
        String winnerNames = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
