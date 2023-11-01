package domain;

import constant.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Cars {
    private final List<Car> carList;

    Cars(List<String> names) {
        this(names, Stream.generate(() -> Car.INITIAL_POSITION)
                .limit(names.size())
                .toList()
        );
    }

    Cars(List<String> names, List<Integer> position) {
        carList = IntStream.range(0, names.size())
                .mapToObj(i -> new Car(names.get(i), position.get(i)))
                .collect(Collectors.toUnmodifiableList());
    }

    public void moveCars() {
        for (int i = 0; i < carList.size(); i++) {
            if (decideGo(getRandomNumber())) {
                go(i);
                continue;
            }
            stop(i);
        }
    }

    private void go(int index) {
        carList.get(index).go();
    }

    private void stop(int index) {
        carList.get(index).stop();
    }

    boolean decideGo(int condition) {
        return condition >= Car.STANDARD_FOR_GO;
    }

    private int getRandomNumber() {
        return pickNumberInRange(Car.MINIMUM_INITIAL_POSITION, Car.MAXIMUM_INITIAL_POSITION);
    }

    public List<Car> decideWinner() {
        int max = getMaxPosition();
        return carList.stream()
                .filter(car -> car.getPosition() == max)
                .toList();
    }

    private int getMaxPosition() {
        validateCarList();
        return carList.stream()
                .max(Car::compareTo)
                .get()
                .getPosition();
    }

    private void validateCarList() {
        if (carList.isEmpty()) {
            throw new RuntimeException(ExceptionMessage.CARLIST_IS_EMPTY.getMessage());
        }
    }

    public int size() {
        return carList.size();
    }

    public List<Car> getAll() {
        return new ArrayList<>(carList);
    }
}
