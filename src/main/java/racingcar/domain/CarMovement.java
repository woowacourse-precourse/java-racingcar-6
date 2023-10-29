package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class CarMovement {
    private List<Integer> getRandomNumberPerCar(int numberOfCars) {
        List<Integer> randomNumberPerCar = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            randomNumberPerCar.add(Randoms.pickNumberInRange(0, 9));
        }
        return randomNumberPerCar;
    }

    public List<Boolean> getCarMoveResult(int numberOfCars) {
        List<Integer> randomNumberPerCar = getRandomNumberPerCar(numberOfCars);
        List<Boolean> carMoveResult = new ArrayList<>();

        for (int i = 0; i < numberOfCars; i++) {
            carMoveResult.add(i, false);
            if (randomNumberPerCar.get(i) >= 4) {
                carMoveResult.add(i, true);
            }
        }
        return carMoveResult;
    }
}
