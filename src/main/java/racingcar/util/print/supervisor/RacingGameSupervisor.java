package racingcar.util.print.supervisor;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.car.Car;

public abstract class RacingGameSupervisor {
    private RacingGameSupervisor() {
    }

    public static List<Car> decideWinner(List<Car> racingCarsList) {
        int winnerDistance = findMaxDistance(racingCarsList);

        return racingCarsList.stream()
                .filter(car ->car.getCurrentPosition() == winnerDistance)
                .collect(Collectors.toList());
    }

    private static int findMaxDistance(List<Car> racingCarsList) {
        return racingCarsList.stream()
                .max(Comparator.comparingInt(Car::getCurrentPosition))
                .map(Car::getCurrentPosition)
                .orElse(0);
    }

}
