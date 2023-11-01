package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.view.TextInterface;

public class RacingCarService {
    private final TextInterface textInterface = new TextInterface();
    private final List<Car> cars = new ArrayList<>();
    private int roundNumber;

    public void initCars(List<String> carNames) {
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public void initRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    private void runOneRound() {
        for (Car car : cars) {
            car.runOneTime();
            textInterface.carStatus(car.toString(), car.getDistance());
        }
    }

    public void runRounds() {
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

    public List<String> getWinnersName() {
        int highestDistance = getHighestDistance();

        List<String> winners = new ArrayList<String>();
        for (Car car : cars) {
            if (car.getDistance() == highestDistance) {
                winners.add(car.toString());
            }
        }
        return winners;
    }
}
