package racingcar.car;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class CarService {

    public ArrayList<Car> createCarList() {
        ArrayList<Car> carList = new ArrayList<>();
        String[] carNames = Console.readLine().split(",");
        for (String carName : carNames) {
            Car car = new Car(carName);
            carList.add(car);
        }
        return carList;
    }
}
