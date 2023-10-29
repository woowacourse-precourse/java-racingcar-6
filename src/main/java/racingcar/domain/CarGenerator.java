package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.LinkedHashMap;

public class CarGenerator {

    Car car = new Car();

    public LinkedHashMap<String, String> createCarList() {
        LinkedHashMap<String, String> carList = new LinkedHashMap<>();
        String[] cars = splitStringByCommas(inputCarList());
        for (String car : cars) {
            carList.put(car, "");
        }
        return carList;
    }

    public String[] splitStringByCommas(String inputCarList) {
        String[] carList = inputCarList.split(",");
        return carList;
    }

    public String inputCarList() {
        String carList = Console.readLine();
        return carList;
    }


}
