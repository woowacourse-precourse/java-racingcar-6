package racingcar.Model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.Util.CarMovement;

public class Cars {

    private int carsLength;
    private List<Car> cars = new ArrayList<>();


    public void addCar(String[] names){
        carsLength = names.length;
        for (String name : names) {
            cars.add(new Car(name));
        }
    }


}
