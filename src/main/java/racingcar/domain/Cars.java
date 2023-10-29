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

    public void playSingleTurn(){
        for (Car car : cars) {
            car.move();
        }
    }

    public Map<String,Integer> getCurrentPositon(){
        Map<String,Integer> currentPostion = new HashMap<>();
        for (Car car : cars) {
            currentPostion.put(car.getName(), car.getPosition());
        }
        return currentPostion;
    }




}
