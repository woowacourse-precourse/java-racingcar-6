package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
public class Race {
    private final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public void runRace(int numberOfTries) {
        for (int i = 0; i < numberOfTries; i++) {
            raceOnce();
            printRoundResult();
        }
    }

    private void raceOnce() {
        for (Car car : cars) {
            car.moveForward(Randoms.pickNumberInRange(0, 9));
        }
    }

    private void printRoundResult() {
        for (Car car : cars) {
            car.printPosition();
        }
        System.out.println();
    }

    public List<Car> findWinners() {
        int maxPosition = findMaxPosition();
        return filterWinners(maxPosition);
    }

    private int findMaxPosition() {
        int maxPosition = -1;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    private List<Car> filterWinners(int maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            addWinnerIfPositionMatches(winners, car, maxPosition);
        }
        return winners;
    }

    private void addWinnerIfPositionMatches(List<Car> winners, Car car, int maxPosition) {
        if (car.getPosition() == maxPosition) {
            winners.add(car);
        }
    }
}
