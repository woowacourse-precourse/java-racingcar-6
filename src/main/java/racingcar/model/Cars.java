package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.validator.Validator;

import java.util.ArrayList;
import java.util.List;

import static racingcar.util.StringUtils.splitByComma;

public class Cars {
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;
    private static final String CAR_NAME_SPLIT = ",";


    private final List<Car> cars = new ArrayList<>();


    public Cars(String carNames) {
        String[] carList = splitByComma(carNames, CAR_NAME_SPLIT);
        Validator.checkDuplicateCarNames(carList);
        for (String carName : carList) {
            cars.add(new Car(carName));
        }
    }


    public Winners getWinners() {
        return new Winners(cars);
    }
    public List<Car> getCars() {
        return cars;
    }

    public void moveByRandomNumber() {
        for (Car car : cars) {
            car.goOrStop(getRandomNumber());
        }
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }
}
