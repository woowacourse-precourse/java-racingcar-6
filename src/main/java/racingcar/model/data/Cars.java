package racingcar.model.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import racingcar.model.generator.MovementGenerator;
import racingcar.model.record.Name;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static List<Car> FromNames(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(new Name(carName), new Position());
            cars.add(car);
        }

        return cars;
    }

    public void moveCars(MovementGenerator movementGenerator) {
        for (Car car : cars) {
            int value = movementGenerator.generateMovement();
            car.moveOrNot(value);
        }
    }

    public Map<String, Integer> getRankingTable() {
        HashMap<String, Integer> result = new HashMap<>();
        for (Car car : cars) {
            Entry<String, Integer> carStatus = car.getStatus();
            result.put(carStatus.getKey(), carStatus.getValue());
        }
        return result;
    }
}
