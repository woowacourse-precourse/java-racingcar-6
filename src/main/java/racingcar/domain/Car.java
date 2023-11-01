package racingcar.domain;

import racingcar.utility.ExceptionHandler;

import java.util.*;

public class Car {

    private Map<String, Integer> car = new LinkedHashMap<>();

    private ExceptionHandler exceptionHandler = ExceptionHandler.getExceptionHandler();

    public Car(List<String> carNames) {
        for (String carname : carNames) {
            car.put(carname, 0);
        }
    }

    public Set<String> getCarName() {
        return car.keySet();
    }

    public Collection<Integer> getCarMoving() {
        return car.values();
    }

    public void setMovingCount(String carName) {
        car.put(carName, getMovingCount(carName) + 1);
    }

    public int getMovingCount(String carName) {
        return car.get(carName);
    }

}
