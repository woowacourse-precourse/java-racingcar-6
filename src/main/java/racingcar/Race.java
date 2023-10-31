package racingcar;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Referee;
import racingcar.input.InputService;
import racingcar.output.PrintService;

public class Race {

    public static void execute() {
        String[] carNames = startRacing();
        List<Car> cars = Car.create(carNames);
        PrintService.askAttemptCount();
        int currentAttemtCount = 0;
        int attemptCount = InputService.attemptCount();
        race(cars, currentAttemtCount, attemptCount);
        endRacing(cars);
    }

    private static void race(List<Car> cars, int currentAttemtCount, int attemptCount) {
        while (currentAttemtCount < attemptCount) {
            resultReport(cars);
            currentAttemtCount++;
        }
    }

    private static String[] startRacing() {
        PrintService.inputCarNameRequest();
        String[] carNames = InputService.writeCarName().split(",");
        return carNames;
    }

    private static void endRacing(List<Car> cars) {
        PrintService.result(Referee.determineWinner(cars));
        InputService.end();
    }

    private static void resultReport(List<Car> cars) {
        List<Car> reportCar = Referee.report(cars);
        PrintService.show(reportCar);
    }
}
