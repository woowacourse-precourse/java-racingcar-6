package racingcar.model;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> cars){
        this.cars = userInputToCars(cars);
    }


    public List<Car> userInputToCars(List<String> userInput) {
        List<Car> carList = new ArrayList<>();
        for (String name : userInput) {
            CarName carName = new CarName(name);
            Car car = new Car(carName);
            carList.add(car);
        }
        return carList;
    }

    public List<String> findWinners() {
        int maxMove = 0;
        Map<Integer, List<String>> moveMap = new HashMap<>();
        for (Car car : cars) {
            Integer key = car.getMoveCount();
            if (key > maxMove) {
                maxMove = key;
            }
            List<String> values = moveMap.getOrDefault(key, new ArrayList<String>());
            values.add(car.getName());
            moveMap.put(key, values);
        }
        return moveMap.get(maxMove);
    }

    public List<Car> getCars() {
        return cars;
    }

}
