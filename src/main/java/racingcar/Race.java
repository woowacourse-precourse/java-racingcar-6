package racingcar;

import racingcar.car.Car;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Race {

    private List<Car> allCars = new ArrayList<>();

    private void inputCars(){

       String s = Console.readLine();
       String[] cars = s.split(",");

        for (String carName : cars) {
            Car car = new Car(carName,0);
            allCars.add(car);
        }
    }
}
