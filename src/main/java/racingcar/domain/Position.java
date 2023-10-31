package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Position extends Car {
    private static final int INITIAL_DISTANCE = 0;
    private static final String INITIAL_POSITION = "%s : ";
    private static final int MIN_RANDOM = 0;
    private static final int MAX_RANDOM = 9;
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

    public int distanceValue() {
        return this.distance;
    }

    public String positionValue() {
        return this.position.toString();
    }

    public void move(int random) {
        if (random >= 4) {
            this.distance += 1;
            this.position.append("-");
        }
    }

    public static List<Position> createPositions(Set<String> carNames) {
        List<Position> positions = new ArrayList<>();
        for (String carName : carNames) {
            Car car = Car.createCar(carName);
            Position position = Position.createPosition(car);
            positions.add(position);
        }
        return positions;
    }

    public static List<Position> updatePositions(Race race) {
        while (race.positionList().get(0).distanceValue() < race.tryValue()
                && race.positionList().get(1).distanceValue() < race.tryValue()) {
            for (Position position : race.positionList()) {
                int randomDistance = Randoms.pickNumberInRange(MIN_RANDOM, MAX_RANDOM);
                position.move(randomDistance);
                System.out.println(position.positionValue());
            }
            System.out.println();
        }
        return race.positionList();
    }
}
