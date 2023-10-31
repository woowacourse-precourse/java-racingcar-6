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
        System.out.println(PROMPT_CAR_NAME.getValue());
    }

    public static void promptForRaceCount() {
        System.out.println(PROMPT_COUNT.getValue());
    }

    public static void announceWinners(List<Car> winners) {

        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(DELIMITER_PLUS_SPACE.getValue()));

        System.out.println(PREFIX + winnerNames);
    }

    public static void currentLocation(String name, int currentNum) {
        System.out.println(name + COLON + HYPHEN.getValue().repeat(currentNum));
    }

}
