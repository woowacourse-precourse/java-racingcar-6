package racingcar.util;

import racingcar.domain.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarGenerator {

    String namesStr;
    List<String> namesList ;


    public CarGenerator(String carsName) {
        this.namesStr = carsName;
    }

    public void splitNames() {
        namesList = Stream.of(namesStr.split(","))
                .collect(Collectors.toList());
    }

    public List<Car> generateCars(){
        List<Car> cars = new ArrayList<>();
        for(String carName : namesList) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public void checkLengthValidation () {
        for(String carName : namesList){
            Validator.lengthvalidator(carName);
        }
    }



}
