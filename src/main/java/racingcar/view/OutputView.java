package racingcar.view;

import racingcar.model.Car;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OutputView {

    public void printEachCarResult(String name, int score) {
        StringBuilder result = new StringBuilder(name + " : ");
        Optional<String> formattedPosition = Stream.generate(() -> "-").limit(score).reduce((a, b) -> a + b);
        formattedPosition.ifPresent(result::append);
        System.out.println(result);
    }

    public void result(List<Car> cars) {
        StringBuilder result = new StringBuilder();
        result.append("최종 우승자 : ");

        int max_score = cars.stream().max(Comparator.comparingInt(Car::getPosition)).get().getPosition();
        result.append(cars.stream().filter(Car -> Car.getPosition() == max_score).map(Car::getName).collect(Collectors.joining(", ")));

        System.out.println(result);
    }
}
