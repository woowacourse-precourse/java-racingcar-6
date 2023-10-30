package racingcar.utils.result;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.car.Car;

public class ResultGenerator {
    public static final String NEW_LINE = "\n";
    public static final String COMMA_SPACE = ", ";
    public static final String FINAL_WINNERS_COLON = "최종 우승자 : ";

    public String makeExecutionResult(List<Car> cars) {
        return cars.stream()
            .map(Car::makeResult)
            .collect(Collectors.joining(NEW_LINE)) + NEW_LINE;
    }

    public String makeWinnersResult(List<Car> winners) {
        return FINAL_WINNERS_COLON + winners.stream()
            .map(Car::getName)
            .collect(Collectors.joining(COMMA_SPACE));
    }
}
