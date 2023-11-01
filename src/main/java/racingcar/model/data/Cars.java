package racingcar.model.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import racingcar.model.generator.MovementGenerator;
import racingcar.model.record.Name;

/**
 * 자동차 경주에 참여하는 자동차 객체 {@code Car}의 Collection이다.
 */
public class Cars {
    private List<Car> cars;

    /**
     * 주어진 리스트에 따라 자동차 모음을 생성한다.
     *
     * @param cars 자동차들의 리스트
     */
    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    /**
     * 주어진 이름에 따라 자동차 리스트를 초기화한다.
     *
     * @param carNames 자동차 이름을 담은 배열
     * @return 초기화된 자동차의 리스트
     */
    public static List<Car> FromNames(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(new Name(carName), new Position());
            cars.add(car);
        }

        return cars;
    }

    /**
     * 제공된 movementGenerator를 이용하여 리스트에 있는 모든 자동차를 움직인다.
     *
     * @param movementGenerator 자동차 움직임을 결정하는 값 generator
     */
    public void moveCars(MovementGenerator movementGenerator) {
        for (Car car : cars) {
            int value = movementGenerator.generateMovement();
            car.moveOrNot(value);
        }
    }

    /**
     * 모든 자동차의 순위를 계산한다.
     *
     * @return 자동차의 이름과 위치를 담은 자동차 map
     */
    public Map<String, Integer> getRankingTable() {
        HashMap<String, Integer> result = new HashMap<>();
        for (Car car : cars) {
            Entry<String, Integer> carStatus = car.getStatus();
            result.put(carStatus.getKey(), carStatus.getValue());
        }
        return result;
    }
}
