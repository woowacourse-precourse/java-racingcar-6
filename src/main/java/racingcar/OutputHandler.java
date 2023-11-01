package racingcar;

import java.util.List;
import java.util.StringJoiner;

public class OutputHandler {
    private static final String DELIMITER = ", ";

    public void printSubResult(Car car) {
        System.out.println(car);
    }

    public void printFinalResult(List<String> finalWinners) {
        StringJoiner finalWinnersWithDelimiter = getFinalWinnerStringJoiner(finalWinners);
        System.out.println(finalWinnersWithDelimiter);
    }

    private StringJoiner getFinalWinnerStringJoiner(List<String> finalWinners) {
        StringJoiner joiner = new StringJoiner(DELIMITER);
        finalWinners.forEach(item -> joiner.add(item));
        return joiner;
    }
}
