package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class CarSetting {
    private String[] carName;
    private Car[] car;

    CarSetting() {
        carName = Console.readLine().split(",");
        car = new Car[carName.length];
    }

    public void setCars() {
        for (int index = 0; index < carName.length; index++) {
            car[index] = new Car();
            car[index].setCarName(carName[index]);
            if (isGreaterThan()) {
                car[index].increaseRunCount();
            }
        }
    }

    public int makeRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public boolean isGreaterThan() {
        int randomNumber = makeRandomNumber();
        return randomNumber >= 4;
    }
}
