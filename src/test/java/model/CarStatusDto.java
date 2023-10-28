package model;

import java.util.*;

public class CarStatusDto {
    Map<String,Car> cars = new HashMap();

    public void enrollCar(String carName) {
        if(findByName(carName).equals(Optional.empty())) {
            cars.put(carName,new Car(carName,0));
        }
    }

    public Optional<Car> findByName(String name) {
        return Optional.ofNullable(cars.get(name));
    }

    public List<Car> findAll() {
        return new ArrayList<>(cars.values());
    }

    

}
