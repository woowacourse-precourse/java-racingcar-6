package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class RacingGame {

    ArrayList Cars = new ArrayList<Car>();

    public void createCars(String[] carNames) {
        for (int carNumber = 0; carNumber < carNames.length; carNumber++)
        {
            String carName = carNames[carNumber];
            Cars.add(new Car(carName));
        }
    }

    int makeRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(0,9);
        return (randomNumber);
    }
}
