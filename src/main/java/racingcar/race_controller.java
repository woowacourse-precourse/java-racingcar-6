package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class race_controller {
    private Cars cars;
    private int[] storage;
    private Cars_preparation carGoCountMap;
    public race_controller() {
        InputRacingInformation inputRacingInformation = new InputRacingInformation();

        List<String> carNames = inputRacingInformation.InputCarNames();
        storage = new int[cars.size()];
        carGoCountMap = Car_Go_Count_Map(cars, storage);
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

    public Cars_preparation Car_Go_Count_Map(Cars cars, int[] storage) {
        Map<Car, Integer> cars_go_count_map = new LinkedHashMap<>();
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            cars_go_count_map.put(car, storage[i]);
        }
        return new Cars_preparation(cars_go_count_map);
    }
}
