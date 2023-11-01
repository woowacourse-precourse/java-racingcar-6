package racingcar.domain.view.printer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.domain.entity.Car;

public class WinnerPrinter {
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    public static void printWinner(List<Car> winCars) {
        String winners = arrangeWinners(winCars);
        System.out.print(WINNER_MESSAGE + winners);
    }

    private static String arrangeWinners(List<Car> winCars) {
        Stream<Car> carStream = winCars.stream();
        Stream<String> stringStream = carStream.map(Car::getName);
        List<String> strings = stringStream.collect(Collectors.toList());
        return String.join(", ", strings);
    }
}
