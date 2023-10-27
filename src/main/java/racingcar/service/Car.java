package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Car {

    List<String> inputCarList = new ArrayList<>();
    List<String> splitCarList = new ArrayList<>();
    List<String> rangeCarList = new ArrayList<>();

    public List<String> nameInput() {
        String inputCar = Console.readLine();
        inputCarList.add(inputCar);
        return inputCarList;
    }

    public List<String> nameSplit() {

        for (String car : inputCarList) {
            String[] splitCars = car.split(",");
            for (String splitCar : splitCars) {
                splitCarList.add(splitCar.trim());
            }
        }
        return splitCarList;
    }

    public List<String> nameRange() {

        for (String range : splitCarList) {
            if (range.length() <= 5) {
                rangeCarList.add(range);
            }
        }
        System.out.println(rangeCarList);
        return rangeCarList;
    }
}

