package racingcar.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.ArrayList;

import racingcar.Model.Car;

public class Racing {
    List<Car> cars = new ArrayList<>();

    public void UpdateCars(List<String> carNameList)
    {
        for(var carName : carNameList) {
            cars.add(new Car(carName));
        }
    }

    public void progressCarRacing() {
        for(var car : cars) {
            if(isMove())
                car.updatePosition();
        }
    }

    public List<Car> getRacingCar() {
        return cars;
    }

    private static boolean isMove() {
        return getRandomMoveNumber() >= 4;
    }
    private static int getRandomMoveNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
