package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Car {

    public String inputCar = new String();
    public List<String> splitCarList = new ArrayList<>();
    public List<String> rangeCarList = new ArrayList<>();

    public String nameInput() {
        String inputCar = Console.readLine();
        return inputCar;
    }

    public List<String> nameSplit() {
        String[] splitCars = inputCar.split(",");
        for(String car : splitCars){
            splitCarList.add(car);
        }
        return splitCarList;
    }

    public List<String> nameRange() {

        for (String range : splitCarList) {
            if (range.length() <= 5) {
                rangeCarList.add(range);
            }
        }
        return rangeCarList;
    }
}