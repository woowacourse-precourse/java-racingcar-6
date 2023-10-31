package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class OutputView {
    private static final String PREFIX = "최종 우승자 : ";
    private static final String COLON = " : ";
    private static final String HYPHEN = "-";
    private static final String DELIMITER_PLUS_SPACE = ", ";
    private static final String PROMPT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String PROMPT_COUNT = "시도할 회수는 몇회인가요?";

    public static void promptForCarNames() {
        System.out.println(PROMPT_CAR_NAME);
    }

    public static void promptForRaceCount() {
        System.out.println(PROMPT_COUNT);
    }

    public static void announceWinners(List<Car> winners) {

        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(DELIMITER_PLUS_SPACE));

        System.out.println(PREFIX + winnerNames);
    }

    public static void currentLocation(String name, int currentNum) {
        System.out.println(name + COLON + HYPHEN.repeat(currentNum));
    }

}
