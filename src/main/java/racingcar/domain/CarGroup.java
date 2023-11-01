package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class CarGroup {
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int POSITION_INCREMENT_THRESHOLD = 4;
    public List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        this.cars.add(car);
    }

    public int getCarGroupSize() {
        return cars.size();
    }

    public List<Car> getCars() {
        return this.cars;
    }

    private int getMaximumPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public StringJoiner getWinners() {
        int maximumPosition = getMaximumPosition();
        StringJoiner winnerList = new StringJoiner(",");

        cars.stream()
                .filter(car -> car.getPosition() == maximumPosition)
                .map(Car::getNickname)
                .forEach(winnerList::add);

        return winnerList;
    }

    public void moveCars() {
        this.cars.stream()
                .filter(car -> Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER)
                        >= POSITION_INCREMENT_THRESHOLD)
                .forEach(Car::moving);
    }
}
