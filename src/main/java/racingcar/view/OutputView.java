package racingcar.view;

import java.util.Optional;
import java.util.stream.Stream;

public class OutputView {
    final static String WINNER_IS = "최종 우승자 : ";

    public void printEachCarResult(String name, int score) {
        StringBuilder result = new StringBuilder(name + " : ");
        Optional<String> formattedPosition = Stream.generate(() -> "-")
                                                        .limit(score)
                                                        .reduce((a, b) -> a + b);
        formattedPosition.ifPresent(result::append);
        System.out.println(result);
    }

    public void result(String winner) {
        StringBuilder result = new StringBuilder();
        result.append(WINNER_IS);
        result.append(winner);
        System.out.println(result);
    }
}
