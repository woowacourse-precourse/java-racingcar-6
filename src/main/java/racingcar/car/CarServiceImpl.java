package racingcar.car;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.Map;

public class CarServiceImpl implements CarService {
    @Override
    public Map<String, Integer> createCar() {
        HashMap<String, Integer> carList = new HashMap();

        String[] carsName = Console.readLine().split(",");
        for (String carName : carsName) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
            Car car = new Car(carName);
            carList.put(car.getName(), 0);
        }

        return carList;
    }
}
