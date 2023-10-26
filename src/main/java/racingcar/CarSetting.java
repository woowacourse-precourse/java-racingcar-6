package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class CarSetting {
    Input input = new Input();
    String[] carName = input.getInputCars().split(",");
    Car[] car = new Car[carName.length];

    public void setCars() {
        for (int index = 0; index < carName.length; index++) {
            car[index] = new Car();
            car[index].setCarName(carName[index]);

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
