package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.IntStream;

import static racingcar.util.Utils.formatListToString;

public class OutputView {

    public void printResult(List<Car> cars) {
        cars.forEach(car -> {
            System.out.print(car.getName() + " : ");
            printCarDistance(car);
        });
    }

    private void printCarDistance(Car car) {
        IntStream.range(0, car.getDistance())
                .forEach(i -> System.out.print("-"));
        System.out.println();
    }

    public void printWinner(List<String> winners) {
        System.out.print("최종 우승자 : " + formatListToString(winners));
    }

}
