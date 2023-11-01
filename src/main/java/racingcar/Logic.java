package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Logic {

    private List<Car> cars = new ArrayList<>();

    public Logic(List<String> carNames) {
        for(String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void performEachRound() {
        for(Car car : cars) {
            car.performEachRound();
        }
    }

    public List<String> findWinners() {
        List<String> winners = new ArrayList<>();

        int maxPosition = 0;

        for(Car car : cars) {
            if(car.getPositionDistance() > maxPosition) {
                maxPosition = car.getPositionDistance();
                winners.clear();
                winners.add(car.getName());
            } else if(car.getPositionDistance() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

}