package racingcar.utils;

import java.util.List;
import racingcar.domain.Car;

public class MessagePrinter {
    private static final MessagePrinter messagePrinter = new MessagePrinter();

    private MessagePrinter() {
    }

    public static MessagePrinter getInstance() {
        return messagePrinter;
    }

    public void roundResult(final List<Car> cars) {
        cars.forEach(
                car -> System.out.println(getCarName(car) + " : " + createHyphenResult(car)));
    }

    private String getCarName(final Car car) {
        return car.getName();
    }

    private String createHyphenResult(final Car car) {
        final int position = car.getPosition();
        return "-".repeat(position);
    }

    public void winners(final List<Car> winners) {
        List<String> winnerNames = winners.stream()
                .map(Car::getName)
                .toList();
        String result = String.join(", ", winnerNames);
        System.out.println("최종 우승자 : " + result);
    }
}
