package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameManager {
    public List<Car> createCar(String[] carNames) {

        return Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public static void moveCar(List<Car> cars) {
        for (Car car : cars) {
            car.move();
        }
    }

    public int findWinnerCar(List<Car> cars) {
        int max=0;

        for (Car car : cars) {
            max = findMaxPosition(max,car.getPosition());
        }

        return max;
    }

    private int findMaxPosition(int max,int position) {

        if (max < position) {
            max = position;
        }

        return max;
    }

    public static String resultPosition(Car car) {
        StringBuilder resultPosition = new StringBuilder();

        for (int i = 0; i < car.getPosition(); i++) {
            resultPosition.append("-");
        }

        return resultPosition.toString();
    }
}
