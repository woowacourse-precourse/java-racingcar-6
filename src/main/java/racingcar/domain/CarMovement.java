package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class CarMovement {
    public CarMovement() {
    }

    public boolean getRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber > 3;
    }

    public void movement(List<Car> carList) {
        for (int carNumber = 0; carNumber < carList.size(); carNumber++) {
            if (getRandomNumber()) forward(carList, carNumber);
        }
    }

    public void forward(List<Car> carList, int carNumber) {
        String location = carList.get(carNumber).getLocation();
        location += "-";
        carList.get(carNumber).setLocation(location);
    }
}
