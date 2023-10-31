package racingcar.model;

import racingcar.util.GameUtil;
import racingcar.validator.CarNameValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    public static ArrayList<Car> cars = new ArrayList<Car>();

    public Cars(String input){
        CarNameValidator validator = new CarNameValidator(input);
        for (String Name:validator.NAMES){
            Car car = new Car(Name);
            cars.add(car);
        }
    }

    public void move(){
        for(Car car:cars){
            car.move(GameUtil.getRandomNumber());
        }
    }

    public static int getMaxPosition(){
        return cars.stream()
                .mapToInt(Car::getCarPosition)
                .max()
                .orElse(0);
    }

    public static List<String> getWinners(){
        return cars.stream()
                .filter(car -> car.getCarPosition() == getMaxPosition())
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    public static HashMap<String, Integer> carsStates(){
        LinkedHashMap<String,Integer> carsState = new LinkedHashMap<>();
        for(Car car:cars){
            carsState.put(car.getCarName(), car.getCarPosition());
        }
        return carsState;
    }

}
