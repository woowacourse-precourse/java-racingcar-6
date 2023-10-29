package racingcar.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cars {

    private List<Car> cars;

    public Cars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public void playSingleTurn() {
        for (Car car : cars) {
            car.move();
        }
    }

    public Map<String, Integer> carsInformation() {
        Map<String, Integer> currentPostion = new HashMap<>();
        for (Car car : cars) {
            currentPostion.put(car.getName(), car.getPosition());
        }
        return currentPostion;
    }

    public int getCurrnetMaxPosition() {
        int currnetMaxPosition = 0;
        for (Car car : cars) {
            currnetMaxPosition = Math.max(currnetMaxPosition, car.getPosition());
        }
        return currnetMaxPosition;
    }

    public List<Car> findWinner(int currnetMaxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == currnetMaxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }


}
