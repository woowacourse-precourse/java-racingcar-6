package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class CarName {

    public List<String> splitCarList = new ArrayList<>();
    public List<String> rangeCarList = new ArrayList<>();


    public List<String> split() {
        String inputCar = Console.readLine();
        String[] splitCars = inputCar.split(",");
        for (String car : splitCars) {
            splitCarList.add(car);
        }
        System.out.println(splitCarList);
        return splitCarList;
    }

    public List<String> range() {

        for (String range : splitCarList) {
            if (range.length() <= 5) {
                rangeCarList.add(range);
            }
        }
        System.out.println(rangeCarList);
        return rangeCarList;
    }
}