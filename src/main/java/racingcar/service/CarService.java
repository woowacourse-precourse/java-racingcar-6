package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.util.Constants;

public class CarService {
    private final List<Car> cars = new ArrayList<>();

    public void initCars(List<String> carNames) {
        for (String name : carNames) {
            Car car = new Car(name);
            cars.add(car);
        }
    }

    private void runOneRound() {
        for (Car car : cars) {
            car.runOneRound();
            car.printNowStatus();
        }
    }

    public void runRounds(int roundNumber) {
        for (int i = 0; i < roundNumber; i++) {
            runOneRound();
            System.out.println();
        }
    }


    private int getHighestDistance() {
        int highestDistance = 0;
        for (Car car : cars) {
            highestDistance = Math.max(car.getDistance(), highestDistance);
        }
        return highestDistance;
    }

    public List<String> getResult() {
        List<String> winners = new ArrayList<String>();
        int highestDistance = getHighestDistance();
        for (Car car : cars) {
            if (car.getDistance() == highestDistance) {
                winners.add(car.toString());
            }
        }
        return winners;
    }
}
