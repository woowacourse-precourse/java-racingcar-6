package racingcar.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.Random;
import racingcar.model.Car;

public class InputCarName {

    public Car inputCarName() {
        String carName = readLine();
        Car cars = new Car(Arrays.asList(carName.split(",")));

        //자동차 이름 예외처리

        return cars;
    } //Car class instance return

    public void selectCarCondition() {
        do {
            Car.carCondition = Randoms.pickNumberInRange(0, 9);
        } while (Car.carCondition <= Car.MOVE_CONDITION);
    }
}
