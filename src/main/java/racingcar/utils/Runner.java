package racingcar.utils;

import racingcar.domain.Car;

import java.util.List;

public class Runner {
    public static void runRound(List<Car> cars) {
        cars.stream().forEach(car -> {
            int random = RandomNumberGenerator.generateRandomNumber();
            MoveStatus moveStatus = MoveDecider.decideToMove(random);

            if (moveStatus == MoveStatus.MOVE) {
                car.moveForward();
            }
        });
    }
}
