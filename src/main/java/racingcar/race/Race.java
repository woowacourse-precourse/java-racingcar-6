package racingcar.race;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.car.Car;

public class Race {

    private final List<Car> cars;
    private int currentRuntime = 0;
    private int runtime;


    public Race(List<Car> cars) {
        this.cars = cars;
    }


    public void start(int runtime) {
        this.runtime = runtime;
    }

    public boolean next() {
        return currentRuntime != runtime;
    }

    public List<Car> getWinners() {
        int maxDistance = getMaxDistance();
        int stopDistance = 0;

        if (maxDistance == stopDistance) {
            return Collections.emptyList();
        }

        return cars.stream()
                .filter(car -> car.isInPosition(maxDistance))
                .toList();
    }

    public List<Car> tick() {
        currentRuntime++;

        List<Integer> movementList = generateCarDistanceMovementList();
        moveCars(movementList);

        return List.copyOf(cars);
    }

    private void moveCars(List<Integer> movementList) {
        IntStream.range(0, cars.size())
                .filter(i -> movementList.get(i) >= 4)
                .forEach(i -> cars.get(i).moveForward());
    }

    private List<Integer> generateCarDistanceMovementList() {
        return IntStream.range(0, cars.size())
                .map(i -> Randoms.pickNumberInRange(1, 9))
                .boxed()
                .collect(Collectors.toList());
    }


    private Integer getMaxDistance() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }


}
