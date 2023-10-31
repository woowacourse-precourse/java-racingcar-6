package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Cars;

public class OutputView {
    private static final String MSG_RESULT = "실행 결과";
    private static final String MSG_WINNERS = "최종 우승자 : ";
    private static final String COLON = " : ";
    private static final String DASH = "-";
    private static final String DELIMITER = ", ";
    private static final String NEW_LINE = "\n";

    public static void printResult() {
        System.out.println(MSG_RESULT);
    }

    public static void printWinners(List<String> winners) {
        System.out.println(MSG_WINNERS + String.join(DELIMITER, winners));
    }

    public static void printCurrentCarLocation(Cars cars) {
        String carLocation = cars.getCars().stream()
                .map(car -> car.getName() + COLON + DASH.repeat(car.getPosition()))
                .collect(Collectors.joining(NEW_LINE));
        System.out.println(carLocation + NEW_LINE);
    }
}
