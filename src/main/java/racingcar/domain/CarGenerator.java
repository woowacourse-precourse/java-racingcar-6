package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import racingcar.car.Car;
import java.util.LinkedHashMap;

public class CarGenerator {

    Car car = new Car();

    public LinkedHashMap<String,String> createCarList() {
        LinkedHashMap<String,String> carList = new LinkedHashMap<>();
        String [] cars = splitStringByCommas();
        for(String car : cars) {
            carList.put(car,"");
        }
        return carList;
    }

    public void setCarListToCar() {
        car.setCarList(createCarList());
    }

    public String[] splitStringByCommas() {
        String[] carList = Console.readLine().split(",");
        return carList;
    }
}
