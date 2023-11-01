package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class CarManager {
    private List<Car> cars;

    // 자동차들을 등록합니다.
    public void setCars(List<String> carNames) {
        if (cars == null) {
            cars = new ArrayList<Car>();
        }

        for(String carName : carNames) {
            Car newCar = new Car(carName);
            cars.add(newCar);
        }
    }

    // 모든 자동차를 전진하거나 멈춥니다.
    public void moveEachCar()
    {
        for(Car car : cars) {
            if (Randoms.pickNumberInRange(0,9) >= 4) {
                car.move();
            }

            Output.printRoundResults(car.getName(), car.getMoveCnt());
        }

        Output.printLine();
    }

    // TODO : 우승자(가장 많이 전진한 자동차)를 구합니다.
}
