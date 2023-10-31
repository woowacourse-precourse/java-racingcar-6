package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Referee;
import racingcar.input.InputService;
import racingcar.output.PrintService;

public class Race {

    public static void execute() {
        String[] carNames = InputService.writeCarName().split(",");
        List<Car> cars = Car.create(carNames);
        PrintService.askAttemtCount();
        int currentAttemtCount = 0;
        int attemptCount = InputService.attemptCount();
        while (currentAttemtCount < attemptCount) {
            Referee.report(cars);
            PrintService.nextLine();
            currentAttemtCount++;
        }
        Referee.announceWinner(cars);
    }
}
