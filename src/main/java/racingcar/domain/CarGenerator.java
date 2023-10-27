package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import racingcar.car.Car;

public class CarGenerator {

    Car car = new Car();

    public void createCarList() {

    }

    public String[] splitStringByCommas() {
        String[] carList = Console.readLine().split(",");
        return carList;
    }
}
