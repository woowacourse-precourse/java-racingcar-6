package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Position extends Car {
    private static final int INITIAL_DISTANCE = 0;
    private static final String INITIAL_POSITION = "%s : ";
    private static final int MIN_RANDOM = 0;
    private static final int MAX_RANDOM = 9;

    private static final int STANDARD_VALUE = 4;

    private static final int MOVING_DISTANCE = 1;
    private static final String MOVING_POSITION = "-";
    private int distance;
    private StringBuilder position;

    private Position(Car car) {
        super(car.carInfo());
        this.distance = INITIAL_DISTANCE;
        this.position = new StringBuilder(String.format(INITIAL_POSITION, car.carInfo()));
    }

    public static Position createPosition(Car car) {
        return new Position(car);
    }

    public static List<Position> createPositions(Set<String> carNames) {
        return carNames.stream()
                .map(Car::createCar)
                .map(Position::createPosition)
                .collect(Collectors.toList());
    }


    public int distanceValue() {
        return this.distance;
    }

    public String positionValue() {
        return this.position.toString();
    }

    public void move(int random) {
        if (random >= STANDARD_VALUE) {
            this.distance += MOVING_DISTANCE;
            this.position.append(MOVING_POSITION);
        }
    }

    public static List<Position> updatePositions(Race race) {
        while (race.positionValues().get(0).distanceValue() < race.tryValue()
                && race.positionValues().get(1).distanceValue() < race.tryValue()) {
            for (Position position : race.positionValues()) {
                int randomDistance = Randoms.pickNumberInRange(MIN_RANDOM, MAX_RANDOM);
                position.move(randomDistance);
                System.out.println(position.positionValue());
            }
            System.out.println();
        }
        return race.positionValues();
    }
}
