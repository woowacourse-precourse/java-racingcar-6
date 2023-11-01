package racingcar.view;

import static racingcar.model.OutputConstants.COLON;
import static racingcar.model.OutputConstants.DELIMITER_PLUS_SPACE;
import static racingcar.model.OutputConstants.HYPHEN;
import static racingcar.model.OutputConstants.PREFIX;
import static racingcar.model.OutputConstants.PROMPT_CAR_NAME;
import static racingcar.model.OutputConstants.PROMPT_COUNT;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class OutputView {

    public static void promptForCarNames() {
        System.out.println(PROMPT_CAR_NAME);
    }

    public static void promptForRaceCount() {
        System.out.println(PROMPT_COUNT);
    }

    public static void printWinners(List<Car> winners) {
        String delimiter = DELIMITER_PLUS_SPACE.getValue();
        String printWinners = announceWinners(winners, delimiter);
        System.out.println(PREFIX + printWinners);
    }

    public static String announceWinners(List<Car> winners, String delimiter) {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(delimiter));
    }

    public static void currentLocation(String name, int currentNum) {
        String locationString = getLocationString(name, currentNum);
        System.out.println(locationString);
    }

    private static String getLocationString(String name, int currentNum) {
        return name + COLON + HYPHEN.repeat(currentNum);
    }
}
