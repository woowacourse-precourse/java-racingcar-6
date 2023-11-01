package racingcar;

import camp.nextstep.edu.missionutils.*;
import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        String[] carNames = InputView.getCarNames();
        int attemptCount = InputView.getAttemptCount();

        System.out.println();
        System.out.println("실행 결과");

        Race race = new Race(carNames);
        for (int i = 0; i < attemptCount; i++) {
            race.moveCars();
            ResultView.printRace(race.getCars());
        }
        List<Car> winners = findWinners(race.getCars());
        ResultView.printWinners(winners);
    }

    public static List<Car> findWinners(List<Car> cars){
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
