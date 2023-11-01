package racingcar.utils;

import racingcar.domain.Car;

import java.util.List;

public class Runner {
    private Runner() {
    }

    public static void runRound(List<Car> cars) {
        cars.forEach(Runner::runRoundForACar);
    }

    private static void runRoundForACar(Car car) {
        int random = RandomNumberGenerator.generateRandomNumber();
        MoveStatus moveStatus = MoveDecider.decideToMove(random);

        if (moveStatus == MoveStatus.MOVE) {
            car.moveForward();
        }
    }
}
