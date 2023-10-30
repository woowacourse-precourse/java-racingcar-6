package racingcar.firstclasscollection;

import java.util.HashMap;
import java.util.Map;
import racingcar.constant.ExceptionMessage;
import racingcar.model.Car;

public class PositionMap {
    private static final int INIT_POSITION = 0;
    private Map<Car, Integer> positionMap;
    private int winnerPosition;

    public PositionMap() {
        positionMap = new HashMap<>();
        winnerPosition = 0;
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

    /**
     * update car's position in Map
     *
     * @param car
     */
    public void moveCar(Car car) {
        int nextPosition = positionMap.get(car) + 1;
        positionMap.put(car, nextPosition);
        if (winnerPosition < nextPosition) {
            winnerPosition = nextPosition;
        }
    }

    // TODO : List<Car> getWinner()
}
