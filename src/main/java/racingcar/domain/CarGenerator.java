package racingcar.domain;

import racingcar.car.Car;
import camp.nextstep.edu.missionutils.Console;
public class CarGenerator {

    Car car = new Car();

    public void createCarList() {

    }

    public String[] splitStringByCommas() {
        String[] carList = Console.readLine().split(",");
        return carList;
    }
}