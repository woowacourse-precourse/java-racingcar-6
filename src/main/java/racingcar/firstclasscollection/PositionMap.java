package racingcar.firstclasscollection;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import racingcar.constant.ExceptionMessage;
import racingcar.model.Car;

public class PositionMap {
    private Map<Car, Integer> positionMap;

    public PositionMap(Supplier<Map> mapSupplier) {
        positionMap = mapSupplier.get();
    }

    public void putCar(Car car) {
        final int INIT_POSITION = 0;
        if (positionMap.containsKey(car)) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_DUPLICATED);
        }
        positionMap.put(car, INIT_POSITION);
    }

    public void moveCar(Car car) {
        int nextPosition = positionMap.get(car) + 1;
        positionMap.put(car, nextPosition);
    }

    public List<Car> getWinners() {
        int winnerPosition = getWinnerPosition();
        return getCarsInPosition(winnerPosition);
    }

    private List<Car> getCarsInPosition(int position) {
        return positionMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == position)
                .map(Entry::getKey)
                .collect(Collectors.toList());
    }

    private int getWinnerPosition() {
        return positionMap.values()
                .stream()
                .max(Integer::compareTo)
                .get();
    }
}
