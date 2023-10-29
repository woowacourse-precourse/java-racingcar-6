package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final int MIN_FORWARD_NUMBER = 4;
    private static final List<Car> carList = new ArrayList<>();
    private static final List<Car> winner = new ArrayList<>();
    private static int maxForward = 0;

    public void addCars(List<Car> inputCarList) {
        carList.addAll(inputCarList);
    }

    public void oneResult(Car car, int randomNumber) {
        if(randomNumber >= MIN_FORWARD_NUMBER) {
            car.upForwardCount();
        }

        if(car.getForwardCount() > maxForward) {
            maxForward = car.getForwardCount();
        }
    }

    public List<Car> getWinner() {
        return winner;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setWinner() {
        for(Car car : carList) {
            if(car.getForwardCount() == maxForward) {
                winner.add(car);
            }
        }
    }
}
