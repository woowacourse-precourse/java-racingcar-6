package racingcar.util;

import racingcar.domain.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarGenerator {

    String namesStr;
    List<String> namesList ;
    List<Car> cars = new ArrayList<>();

    public CarGenerator(String carsName) {
        this.namesStr = carsName;
    }

    private void splitNames() {
        namesList = Stream.of(namesStr.split(","))
                .collect(Collectors.toList());
    }

    private void generateCars(){
        for(String string : namesList) {
            cars.add(new Car(namesList.toString()));
        }
    }


}
