package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import racingcar.car.Car;
import java.util.HashMap;

public class CarGenerator {

    Car car = new Car();

    public void createCarList() {
        HashMap<String,String> carList = new HashMap<>();
        String [] cars = splitStringByCommas();
        for(String car : cars) {
            carList.put(car,"");
        }
        car.setCarList(carList);
    }

    public String[] splitStringByCommas() {
        String[] carList = Console.readLine().split(",");
        return carList;
    }
}
