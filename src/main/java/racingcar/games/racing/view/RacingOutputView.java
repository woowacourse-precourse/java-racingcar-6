package racingcar.games.racing.view;

import java.util.List;

public class RacingOutputView {

    public void printPlayResult(List<String> results) {
        results.forEach(System.out::println);
        System.out.println();
    }
}
