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

    public void initMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void requestPlayTimesMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void roundResultMessage() {
        System.out.println("실행 결과");
    }

    public void enterLine() {
        System.out.println();
    }

    public void roundResult(final List<Car> cars) {
        cars.forEach(
                car -> System.out.println(car.getName() + " : " + createHyphenResult(car)));
    }

    public void winners(final List<Car> winners) {
        final List<String> winnerNames = winners.stream()
                .map(Car::getName)
                .toList();
        final String result = String.join(", ", winnerNames);
        System.out.print("최종 우승자 : " + result);
    }

    private String createHyphenResult(final Car car) {
        final int position = car.getPosition();
        return "-".repeat(position);
    }
}