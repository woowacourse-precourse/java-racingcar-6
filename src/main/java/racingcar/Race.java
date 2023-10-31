package racingcar;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Referee;
import racingcar.input.InputService;
import racingcar.output.PrintService;

public class Race {

    public static void execute() {
        PrintService.inputCarNameRequest();
        String[] carNames = InputService.writeCarName().split(",");
        List<Car> cars = Car.create(carNames);
        PrintService.askAttemptCount();
        int currentAttemtCount = 0;
        int attemptCount = InputService.attemptCount();
        while (currentAttemtCount < attemptCount) {
            List<Car> reportCar = Referee.report(cars);
            PrintService.show(reportCar);
            currentAttemtCount++;
        }
        PrintService.result(Referee.determineWinner(cars));
        InputService.end();
    }
}
