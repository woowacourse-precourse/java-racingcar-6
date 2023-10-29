package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.LinkedHashMap;
import java.util.regex.*;

public class CarGenerator {

    Car car = new Car();

    public LinkedHashMap<String, String> createCarList() {
        LinkedHashMap<String, String> carList = new LinkedHashMap<>();
        String[] cars = splitStringByCommas();
        for (String car : cars) {
            carList.put(car, "");
        }
        return carList;
    }

    public String[] splitStringByCommas() {
        String[] carList = car.getStringCarList().split(",");
        return carList;
    }

    public void inputCarList() {
        car.setStringCarList(Console.readLine());
    }




}
