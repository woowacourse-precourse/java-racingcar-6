package racingcar;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

public class GameHost {

    Collection<Car> carList;

    private GameHost(Collection<Car> cars) {
        this.carList = cars;
    }

    public void playOneTurn() {
        carList.forEach((Car::moveForward));
        printAfterOneTurn();
    }

    private void printAfterOneTurn() {
        carList.forEach((car -> System.out.println(car.toString())));
    }

    public static GameHost addCars(Collection<Car> cars) {
        return new GameHost(cars);
    }

    public String announceWinner(){
        int maxOdometer = 0;
        String winnerName = "";
        for (Car car : carList) {
            if(maxOdometer < car.getOdometer()) {
                winnerName = car.getName();
                maxOdometer = car.getOdometer();
            }
        }
        return winnerName;
    }

}
