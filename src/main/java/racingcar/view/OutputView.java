package racingcar.view;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.dto.ResultPerAttempt;
import racingcar.model.car.Winners;

public class OutputView {

    private static final String ENUMERATION_DELIMITER = ", ";
    private static final String POSITION_SYMBOL = "-";
    private static final String COLON = " : ";
    private static final String NEW_LINE = "\n";

    public void printResultMsg() {
        System.out.println("실행결과");
    }

    public void displayResult(List<ResultPerAttempt> results) {
        StringBuilder output = new StringBuilder();
        results.forEach(result -> output
                .append(result.toString())
                .append(repeat(POSITION_SYMBOL, result.getPosition()))
                .append(NEW_LINE)
        );
        System.out.println(output);
    }

    public void displayWinners(Winners winners) {
        List<String> winnerNames = winners.getWinnerNames();
        StringBuilder output = new StringBuilder("최종 우승자");
        output.append(COLON);
        IntStream.range(0, winnerNames.size())
                .forEach(index -> output.append(winnerNames.get(index)).append(ENUMERATION_DELIMITER));
        output.deleteCharAt(output.lastIndexOf(ENUMERATION_DELIMITER));
        System.out.println(output);
    }

    public String repeat(String source, int repeatCount) {
        StringBuilder result = new StringBuilder();
        for (int index = 0; index < repeatCount; index++) {
            result.append(source);
        }
        return result.toString();
    }
}
