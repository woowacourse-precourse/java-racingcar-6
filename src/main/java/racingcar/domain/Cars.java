package racingcar.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void playSingleTurn(){
        for (Car car : cars) {
            car.move();
        }
    }

    public Map<String,Integer> carsInformation(){
        Map<String,Integer> currentPosition = new HashMap<>();
        for (Car car : cars) {
            currentPosition.put(car.getName(), car.getPosition());
        }
        return currentPosition;
    }

    public int getCurrentPosition() {
        int currentMaxPosition = 0;
        for (Car car : cars) {
            currentMaxPosition = Math.max(currentMaxPosition, car.getPosition());
        }
        return currentMaxPosition;
    }



    public List<Car> findWinner(int currentMaxPosition){
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if(car.getPosition() == currentMaxPosition){
                winners.add(car);
            }
        }
        return winners;
    }



}
