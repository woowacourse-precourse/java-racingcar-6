package racingcar.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cars {
    private UserInputCarName userInputCarName;
    public static List<Car> cars = new ArrayList<>();
    public static Map<String, Integer> findMax = new HashMap<>();

    public Cars(String input) {
        List<String> carName = userInputCarName.createCarName(input);
        for(String name : carName) {
            Car car = new Car(name);
            cars.add(car);
        }
    }

    public void depart(int random){
        for (Car car : cars){
            car.goForward(random);
        }
    }
    public Map<String, Integer> makeHash(){
        for(Car car : cars){
            findMax.put(car.getName(), car.getForward());
        }
        return findMax;
    }

    public int findMaxForward(){
        int maxForward = findMax.values().stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);

        return maxForward;
    }

    



}
