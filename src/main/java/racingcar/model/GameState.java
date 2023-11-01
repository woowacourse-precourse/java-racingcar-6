package racingcar.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GameState {
    private Map<String,String> carStateMap;

    public GameState(ArrayList<Car> carList){
        this.carStateMap= new HashMap<>();
        settingCarStateMap(carList);
    }

    private void settingCarStateMap(ArrayList<Car> carList){
        for(Car car : carList){
            carStateMap.put(car.getCarName(),car.getStepDistence());
        }
    }

    public Map<String, String> getCarStateMap() {
        return carStateMap;
    }
}
