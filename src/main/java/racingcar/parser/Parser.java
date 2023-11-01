package racingcar.parser;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.domain.CarName;

public class Parser {
    private static final String COMMA = ", ";
    private static final String COLON = " : ";
    private static final String HYPHEN = "-";
    private static final String ENTER = "\n";

    public static String parseCarMapToString(Map<CarName, Integer> carMap) {
        String carStatus = carMap
                .entrySet().stream()
                .map(entry -> entry.getKey().getName() + COLON + HYPHEN.repeat(entry.getValue()) + ENTER)
                .collect(Collectors.joining());

        return carStatus;
    }

    public static String parseWinnerList(List<CarName> winnerList) {
        String winners = winnerList.stream()
                .map(CarName::getName)
                .collect(Collectors.joining(COMMA));

        return winners;
    }
}
