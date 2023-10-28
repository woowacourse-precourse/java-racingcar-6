package racingcar;

import java.util.List;

public class GameClientOutput {
    private static final String WINNERS_MESSAGE = "최종 우승자 : ";

    public void printWinners(List<String> winners) {
        System.out.print(WINNERS_MESSAGE);
        System.out.println(String.join(", ", winners));
    }
}
