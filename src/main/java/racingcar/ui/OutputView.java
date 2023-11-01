package racingcar.ui;

import java.util.List;
import racingcar.Car;
import racingcar.Converter;

public class OutputView {
    public static final String NEW_LINE = "\n";
    private static final String COLON = " : ";
    private static final String WINNER_MESSAGE = "최종 우승자";

    public static void printGameResult(Car car, int distance) {
        String convertedDistance = Converter.convertDistance(distance);
        System.out.println(car.getName() + COLON + convertedDistance);
    }

    public static void printWinners(List<Car> winners) {
        List<String> convertedWinners = Converter.convertWinners(winners);
        String winnersConvention = Converter.matchWinnersNameConvention(convertedWinners);

        System.out.print(NEW_LINE);
        System.out.println(WINNER_MESSAGE + COLON + winnersConvention);
    }
}
