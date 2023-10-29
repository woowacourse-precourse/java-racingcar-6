package racingcar;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class CarFuntion {
    public int forwardNumber = 0;
    private static final List<Car> cars = new ArrayList<Car>();
    public static List<String> CarNameList = new ArrayList<String>();

    public void makeCar(String carNames) {
        CarNameList = List.of(carNames.split(","));
        for (String carName : CarNameList) {
            this.cars.add(new Car(carName));
        }
    }

    public void forwardCar() {
        for (Car car : cars) {
            if(Randoms.pickNumberInRange(0,9) > 3) {
                car.forwardNumber++;
            }
        }
    }

    public static List<Car> getCar(){
        return cars;
    }

}
