package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class CarMovement {
    public static final List<String> carMoveResult = new ArrayList<>();

    public List<String> getStringResult(int numberOfCars) {
        List<Integer> randomNumberPerCar = getRandomNumberPerCar(numberOfCars);
        getCarMoveResult(randomNumberPerCar);
        return carMoveResult;
    }

    private List<Integer> getRandomNumberPerCar(int numberOfCars) {
        List<Integer> randomNumberPerCar = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            randomNumberPerCar.add(Randoms.pickNumberInRange(0, 9));
        }
        return randomNumberPerCar;
    }

    public static void getCarMoveResult(List<Integer> randomNumberPerCar) {
        carMoveResult.clear();
        for (int i = 0; i < randomNumberPerCar.size(); i++) {
            carMoveResult.add("");
            if (randomNumberPerCar.get(i) >= 4) {
                carMoveResult.set(i, "-");
            }
        }
    }
}
