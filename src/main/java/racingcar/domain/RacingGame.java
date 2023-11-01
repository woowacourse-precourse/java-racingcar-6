package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    public static int carCount;
    private final List<RacingCar> cars = new ArrayList<>();
    private final List<RacingCar> winners = new ArrayList<>();

    public RacingGame(List<String> names) {
        for (String name : names) {
            RacingCar car = new RacingCar(name);
            cars.add(car);
        }
        setCarCount();
    }

    public void moveCarForward() {
        for (RacingCar car : cars) {
            car.moveRandomForward();
        }
    }

    private void setCarCount() {
        carCount = cars.size();
    }

    public int getCarMove(int index) {
        return cars
                .get(index)
                .getMove();
    }

    public String getCarName(int index) {
        return cars
                .get(index)
                .getCarName();
    }

    public List<String> getWinnerNames() {
        setWinners();
        List<String> winnerNames = new ArrayList<>();
        for (RacingCar winner : winners) {
            winnerNames.add(winner.getCarName());
        }
        return winnerNames;
    }

    private void setWinners() {
        int max = findMax();
        for (RacingCar car : cars) {
            addWinner(max, car);
        }
    }

    private void addWinner(int max, RacingCar car) {
        int carMove = car.getMove();
        if (max == carMove) {
            winners.add(car);
        }
    }

    private int findMax() {
        int max = 0;
        for (RacingCar car : cars) {
            int carMove = car.getMove();
            if (max < carMove) {
                max = carMove;
            }
        }
        return max;
    }

    public void moveForwardIndex(int i) {
        cars.get(i).moveForward();
    }
}
