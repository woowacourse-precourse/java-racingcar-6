package racingcar;

import java.util.List;

public class Action {

    final static int PLUS_NUMBER = 3;

    public static void moveCar(List<Car> carName) {

        for (Car car : carName) {
            int moveValue = RandomNum.number();
            if (moveValue > PLUS_NUMBER) {
                car.setDistance();
            }
        }

    }
}
