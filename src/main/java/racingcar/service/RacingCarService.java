package racingcar.service;

import java.util.List;
import java.util.ArrayList;

import racingcar.domain.Car;
import camp.nextstep.edu.missionutils.Randoms;

public class RacingCarService {
    private static final int RANDOM_MIN_NUMBER = 0;
    private static final int RANDOM_MAX_NUMBER = 9;
    private static final int MOVE_CONDITION = 4;
    private final List<Car> carList = new ArrayList<>();

    public List<Car> participateCar(List<String> carsName) {
        for(String name : carsName){
            carList.add(new Car(name));
        }
        return carList;
    }
    public void moveCar() {
        List<Integer> randomNumbers = generateRandomNumbers();
        for (int i = 0; i < carList.size(); i++) {
            if (randomNumbers.get(i) >= MOVE_CONDITION) {
                carList.get(i).move();
            }
        }
    }
    private List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < carList.size(); i++) {
            randomNumbers.add(Randoms.pickNumberInRange(RANDOM_MIN_NUMBER, RANDOM_MAX_NUMBER));
        }
        return randomNumbers;
    }
}
