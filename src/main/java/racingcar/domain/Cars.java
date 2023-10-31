package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.util.RacingGameUtil;

public class Cars {
    private List<Car> carList = new ArrayList<>();


    public Cars(String carNames) {
        List<String> carNameList = RacingGameUtil.splitCarNames(carNames);
        for (String carName : carNameList) {
            Car car = new Car(carName, 0);
            this.carList.add(car);
        }
    }

    public void moveByCycle() {
        for (Car car : carList) {
            goEachCar(car);
        }

    }

    private void goEachCar(Car car) {
        int randNumber = Randoms.pickNumberInRange(0, 9);
        car.go(randNumber);
    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(carList);
    }

    public List<Car> getModifiableCarList() {
        return carList;
    }


    public List<String> winner() {
        List<String> winnerNames = new ArrayList<>();
        int maxPosition = 0;

        for (Car car : carList) {
            if (car.getPosition() == maxPosition) {
                winnerNames.add(car.getName());
                continue;
            }
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
                winnerNames = new ArrayList<>();
                winnerNames.add(car.getName());
            }
        }
        return winnerNames;
    }
}
