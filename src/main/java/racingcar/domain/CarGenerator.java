package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import racingcar.car.Car;
import java.util.HashMap;

public class CarGenerator {

    Car car = new Car();

    public HashMap<String,String> createCarList() {
        HashMap<String,String> carList = new HashMap<>();
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
