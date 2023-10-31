package racingcar.games.racing.view;

import java.util.List;

public class RacingOutputView {

    private static final String DELIMITER = ", ";

    public void printWinners(List<String> winners) {
        String result = String.join(DELIMITER, winners);
        System.out.println("최종 우승자 : " + result);
    }

    public void printPlayResult(List<String> results) {
        results.forEach(System.out::println);
        System.out.println();
    }

}
