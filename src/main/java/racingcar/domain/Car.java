package racingcar.domain;

import java.util.List;
import racingcar.exception.NoExistCarException;
import racingcar.util.converter.NameAndDistanceMessageGenerator;

public class Car {

    private static final int INITIAL_DISTANCE = 0;
    private static final int DISTANCE_PER_MOVE = 1;
    private static final int MIN_REQUIRED_GASOLINE = 4;
    private static final NameAndDistanceMessageGenerator nameAndDistanceMessageGenerator = new NameAndDistanceMessageGenerator();

    private final String name;
    private int drivenDistance = INITIAL_DISTANCE;

    private Car(String name) {
        this.name = name;
    }

    public static Car from(String name) {
        return new Car(name);
    }

    public void tryDrive(int gasoline) {
        if (gasoline < MIN_REQUIRED_GASOLINE) {
            return;
        }
        drive();
    }

    public String generateNameAndDistanceMessage() {
        return nameAndDistanceMessageGenerator.generate(name, drivenDistance);
    }

    public boolean matchesDrivenDistance(int expectedDistance) {
        return drivenDistance == expectedDistance;
    }

    public void standAsWinner(WinnerStand winnerStand) {
        winnerStand.addWinner(name);
    }

    public static int getMaxDistanceAmongCars(List<Car> cars) {
        return cars.stream()
                .mapToInt(car -> car.drivenDistance)
                .max()
                .orElseThrow(NoExistCarException::new);
    }

    private void drive() {
        drivenDistance += DISTANCE_PER_MOVE;
    }
}
