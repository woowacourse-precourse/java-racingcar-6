package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputManager {
    public List<Car> inputCarName(){
        System.out.println(MassageManager.INPUT_CAR_NAME);
        String containComma = Console.readLine();

        List<String> names = Arrays.stream(containComma.split(","))
                .toList();

        List<Car> cars = new ArrayList<Car>();
        for (int i = 0; i <names.size(); i++){
            cars.add(new Car(names.get(i)));
        }
        return cars;
    }
}
