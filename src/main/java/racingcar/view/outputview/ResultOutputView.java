package racingcar.view.outputview;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static racingcar.view.Parameter.Output.WINNERS;

public final class ResultOutputView implements OutputView {
    private static final String WINNER_DELIMITER = ", ";

    @Override
    public void display(Map<String, Object> displayEntities) {
        if (displayEntities.get(WINNERS) instanceof Cars cars) {
            printWinners(cars.cars());
        }
    }

    private void printWinners(List<Car> cars) {
        System.out.print("최종 우승자 : ");

        String winners = convertNameToString(cars);
        System.out.println(winners);
    }

    private String convertNameToString(List<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(WINNER_DELIMITER));
    }
}
