package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.input.InputService;
import racingcar.output.PrintService;

public class Race {

    public static void excute() {
        List<Car> cars = create();
        PrintService.askAttemtCount();
        int currentAttemtCount = 0;
        while(currentAttemtCount < InputService.attemptCount()) {
            report(cars);
            currentAttemtCount++;
        }
    }

    private static List<Car> create() {
        PrintService.inputCarNameRequest();
        String[] cars = InputService.writeCarName().split(",");
        return Arrays.stream(cars).map(Car::createForStart).collect(Collectors.toList());
    }

    private static void report(List<Car> cars) {
        cars.forEach(car -> {
            int value =  RandomMovementLimitGenerator.value();
            car.moveStraight(value);
            PrintService.show();
        });
    }
}
