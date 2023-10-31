package racingcar.view.outputview;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;
import java.util.Map;

public final class ResultOutputView implements OutputView {
    private static final String WINNER_DELIMITER = ", ";

    @Override
    public void display(Map<String, Object> displayEntities) {
        if (displayEntities.get("winners") instanceof Cars cars) {
            printWinners(cars.cars());
        }
    }

    private void printWinners(List<Car> cars) {
        System.out.print("최종 우승자 : ");

        String winners = convertNameToString(cars);
        System.out.println(winners);
    }

    private String convertNameToString(List<Car> cars) {
        List<String> winners = cars.stream()
                .map(Car::getName)
                .toList();

        return String.join(WINNER_DELIMITER, winners);
    }
}
