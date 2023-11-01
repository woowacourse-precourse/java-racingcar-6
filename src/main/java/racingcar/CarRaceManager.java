package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarRaceManager {
    private List<Car> racingCars = new ArrayList<>();

    public List<Car> getRacingCars() {
        return racingCars;
    }

    public void createCarList(List<String> inputCarNames) {
        for (final String carName : inputCarNames) {
            racingCars.add(new Car(carName));
        }
    }

    public void runRace(int attemptNumber) {
        for (int i = 0; i < attemptNumber; i++) {
            nthAttemptRace();
            printAttemptResult();
        }
    }

    public void nthAttemptRace() {
        for (Car car : racingCars) {
            int movingNumber = Utils.generateRandomNumber();
            if (Utils.isMove(movingNumber)) {
                car.moveForward();
            }
        }
    }

    public void printAttemptResult() {
        for (Car car : racingCars) {
            System.out.println(car);
        }
        System.out.println();
    }

    public List<String> getWinners() {
        int maxMovingCount = 0;
        final List<String> winners = new ArrayList<>();

        for (Car car : racingCars) {
            int movingCount = car.getMovingCount();
            if (movingCount > maxMovingCount) {
                maxMovingCount = movingCount;
                winners.clear();
            }

            if (movingCount == maxMovingCount) {
                winners.add(car.getCarName());
            }
        }

        return winners;
    }

    public void printWinner() {
        final List<String> winners = getWinners();
        System.out.print("최종 우승자: " + String.join(", ", winners));
    }
}