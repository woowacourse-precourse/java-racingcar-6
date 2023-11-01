package racingcar.domain;


import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Registration {
    private InputValidator inputValidator;

    public List<Car> registerCars(){
        String input = Console.readLine();
        List<Car> cars = new ArrayList<>();

        for(String carName : input.split(",")){
            inputValidator.validateLength(carName);
            Car newCar = new Car(carName);
            cars.add(newCar);
        }

        return cars;
    }


}
