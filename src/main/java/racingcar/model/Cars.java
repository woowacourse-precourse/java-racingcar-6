package racingcar.model;

import racingcar.util.ExceptionHandling;

import java.util.ArrayList;
import java.util.List;


public class Cars {
    public static List<String> carList = new ArrayList<>();
    public static List<Integer> countList = new ArrayList<>();

    public Cars(String carName) {
        Cars.carList = new ArrayList<>();
        Cars.countList = new ArrayList<>();
        makeCarList(carName);
    }

    private void makeCarList(String carNames) {
        for (String carName : carNames.split(",")) {
            ExceptionHandling.isCarNameNull(carName);
            ExceptionHandling.isCarNameOverSize(carName);
            ExceptionHandling.isCarNameSame(carName, carList);
            countList.add(0);
            carList.add(carName);
        }
    }

}
