package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Register {

    public List<String> registerCar(){

        String inputCarName = Console.readLine();

        List<String> cars = List.of(inputCarName.split(","));

        System.out.println("경주 자동차 목록");
        for (String car : cars) {
            checkCarName(car);
        }

        return cars;
    }

    private void checkCarName(String car){
        if(car.length() > 6){
            throw new IllegalArgumentException();
        }
    }
}
