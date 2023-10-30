package racingcar.firstclasscollection;

import java.util.HashMap;
import java.util.Map;
import racingcar.constant.ExceptionMessage;
import racingcar.model.Car;

public class PositionMap {
    private static final int INIT_POSITION = 0;
    private Map<Car, Integer> positionMap;

    public PositionMap() {
        positionMap = new HashMap<>();
    }

    /**
     * @param car
     * @throws IllegalArgumentException - 중복된 Car 객체를 저장 시도시
     */
    public void addCar(Car car) {
        if (positionMap.containsKey(car)) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_DUPLICATED);
        }
        positionMap.put(car, INIT_POSITION);
    }

    // TODO : void moveCar(Car car)

    // TODO : List<Car> getWinner()
}
