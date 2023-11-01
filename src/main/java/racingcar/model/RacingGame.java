package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars = new ArrayList<>();
    private final int tryCount;

    public RacingGame(String carNames, int tryCount) {
        String[] names = carNames.split(",");
        for (String name : names) {
            cars.add(new Car(name));
        }
        this.tryCount = tryCount;
    }

    public void playOneRound() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> getWinners() {
        List<Car> winners = new ArrayList<>();
        int maxPosition = getMaxPosition();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public int getTryCount() {
        return tryCount;
    }

    public List<String> getCarPositions() {
        List<String> positions = new ArrayList<>();
        for (Car car : cars) {
            StringBuilder positionString = new StringBuilder(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                positionString.append("-");
            }
            positions.add(positionString.toString());
        }
        return positions;
    }
}