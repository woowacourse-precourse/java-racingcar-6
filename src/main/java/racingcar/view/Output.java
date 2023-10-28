package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Name;

public class Output {
    private Output() {
    }

    public static void printWinnersName(List<Car> cars) {
        String winnerList = cars.stream()
                .map(Car::getName)
                .map(Name::toString)
                .collect(Collectors.joining(", ", "최종 우승자: ", ""));

        System.out.println(winnerList);
    }
}
