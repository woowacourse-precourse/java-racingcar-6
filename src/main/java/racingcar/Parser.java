package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    private static final String COMMA = ", ";

    public static String parseWinnerList(List<CarName> winnerList) {
        String winners = winnerList.stream()
                .map(CarName::getName)
                .collect(Collectors.joining(COMMA));

        return winners;
    }
}
