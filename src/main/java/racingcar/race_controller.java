package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class race_controller {
    private Cars cars;

    public race_controller() {
        InputRacingInformation inputRacingInformation = new InputRacingInformation();

        List<String> carNames = inputRacingInformation.InputCarNames();
        cars = createCars(carNames);
    }
    public Cars createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
        return new Cars(cars);
    }
}
