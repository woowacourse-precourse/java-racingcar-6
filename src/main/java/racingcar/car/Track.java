package racingcar.car;

import java.util.ArrayList;
import java.util.List;

public class Track {
    private static final Track instance = new Track();

    private List<Car> cars;

    private Track(){
        cars = new ArrayList<>();
    }

    public static Track getInstance(){
        return instance;
    }

    public void setCars(List<String> nameList){
        for(String name : nameList){
            cars.add(new Car(name));
        }
    }

    public void printCars(){
        for(Car car : cars){
            System.out.println(car.getName());
        }
    }
}
