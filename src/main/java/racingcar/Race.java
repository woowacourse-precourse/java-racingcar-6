package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.input.InputService;
import racingcar.output.PrintService;

public class Race {

    public static void execute() {
        List<Car> cars = create();
        PrintService.askAttemtCount();
        int currentAttemtCount = 0;
        int attemptCount = InputService.attemptCount();
        while (currentAttemtCount < attemptCount) {
            report(cars);
            PrintService.nextLine();
            currentAttemtCount++;
        }
        showWinner(cars);
    }

    private static List<Car> create() {
        PrintService.inputCarNameRequest();
        String[] cars = InputService.writeCarName().split(",");
        return Arrays.stream(cars).map(Car::createForStart).collect(Collectors.toList());
    }

    private static void report(List<Car> cars) {
        cars.forEach(car -> {
            int value = RandomMovementLimitGenerator.value();
            car.moveStraight(value);
            PrintService.show(car);
        });
    }

    private static void showWinner(List<Car> cars) {
        int max = cars.stream().mapToInt(Car::getStraightCount).max()
            .orElseThrow(IllegalArgumentException::new);
        List<String> list = cars.stream().filter(car -> max == car.getStraightCount()).map(Car::getName)
        .toList();
        PrintService.result(list);
    }
}
