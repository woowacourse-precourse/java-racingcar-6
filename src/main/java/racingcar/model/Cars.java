package racingcar.model;

import racingcar.validator.CarNameValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

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
            car.move();
        }
    }

    public static HashMap<String, Integer> carStates(){
        HashMap<String,Integer> carState = new LinkedHashMap<>();
        for(Car car:cars){
            carState.put(car.getCarName(), car.getCarPosition());
        }
        return carState;
    }

}
