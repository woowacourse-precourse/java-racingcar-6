package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class ResultView {
    private static final String POSITION_INDICATOR = "-";
    private static final String MESSAGE_WINNER = "최종 우승자 : ";

    public void printRoundResult(final List<Car> cars) {
        cars.forEach(this::printCarPosition);
        System.out.println();
    }

    private void printCarPosition(final Car car) {
        System.out.println(car.getName() + " : " + getPositionLine(car.getPosition()));
    }

    private String getPositionLine(final int position) {
        return POSITION_INDICATOR.repeat(position);
    }

    public void printWinners(final List<Car> winners) {
        System.out.print(MESSAGE_WINNER + joinWinnerNames(winners));
    }

    private String joinWinnerNames(final List<Car> winners) {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
