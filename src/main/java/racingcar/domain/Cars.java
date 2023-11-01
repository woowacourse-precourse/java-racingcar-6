package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public int size() {
        return cars.size();
    }

    public Cars(String names) {
        this.cars = Arrays.stream(names.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void race(int[] numbers) {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).goForwardByNumber(numbers[i]);
        }
    }
    public String getPositions() {
        StringBuilder positions = new StringBuilder();
        cars.forEach(car -> positions.append(car.toString()).append("\n"));

        return positions.toString();
    }

    public int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPositionNumber)
                .max()
                .orElse(0);
    }
    public List<String> getWinners() {
        int maxPositionNumber = getMaxPosition();
        return cars.stream()
                .filter(car -> car.isWinner(maxPositionNumber))
                .map(car -> car.getName().toString())
                .collect(Collectors.toList());
    }

}
