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


    private List<Car> userInputToCars(List<String> userInput) {
        List<Car> carList = new ArrayList<>();
        for (String name : userInput) {
            CarName carName = new CarName(name);
            Car car = new Car(carName);
            carList.add(car);
        }
        return carList;
    }

    public List<Car> getCars() {
        return cars;
    }

}
