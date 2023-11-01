package racingcar.View;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class OutputView {
    public static final String WINNER_GUIDE_MESSAGE = "최종 우승자 : ";

    public void printRound() {

    }

    public void printCarResult() {

    }

    public void printWinners(ArrayList<String> winners) {
        System.out.println(WINNER_GUIDE_MESSAGE + winners.stream()
                .collect(Collectors.joining((", "))));
    }
}
