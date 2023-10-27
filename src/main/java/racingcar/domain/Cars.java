package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(){
        this.cars = new ArrayList<>();
    }

    public void generateCars(String input){
        String[] inputArr = input.split(",");
        for(String s:inputArr){
            cars.add(new Car(s));
        }
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
