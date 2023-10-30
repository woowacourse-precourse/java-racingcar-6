package racingcar;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class CarFuntion {
    private final List<Car> cars = new ArrayList<Car>();
    public void makeCar(String carNames) {
        List<String> CarNameList = List.of(carNames.split(","));

        for (String carName : CarNameList) {
            this.cars.add(new Car(carName, 0));
        }
    }

    void forwardCar(List<Car> cars) {
        for (Car car : cars) {
            if(Randoms.pickNumberInRange(0,9) > 3) {
                car.forwardNumber++;
            }
        }
    }

    public List<Car> getCar(){
        return cars;
    }

}
