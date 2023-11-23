package racingcar.domain.view.printer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.domain.entity.Car;

public class WinnerPrinter {
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String ARRAY_WINNER_WITH_COMMA = ", ";

    public static void printWinner(List<Car> winCars) {
        String winners = arrangeWinners(winCars);
        System.out.print(WINNER_MESSAGE + winners);
    }

    private static String arrangeWinners(List<Car> winCars) {
        List<String> winners = winCars.stream().map(Car::getName).collect(Collectors.toList());
        return String.join(ARRAY_WINNER_WITH_COMMA, winners);
    }
}
