package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
    private static Integer randdomNumber;

    public static List<Car> inputToCarList(String input) {
        return Arrays.stream(input.split(","))
                .map(Car::new)
                .toList();
    }

    public static void isForward(List<Car> cars) {
        for (Car car : cars) {
            randdomNumber = Randoms.pickNumberInRange(0, 9);
            if (randdomNumber >= 4) car.forward();
        }
    }

    public static List<Car> findWinner(List<Car> cars) {
        List<Car> winnerCars = new ArrayList<>();
        Integer maxPos = 0;
        for (Car car : cars) {
            if (maxPos == car.getPosition()) winnerCars.add(car);
            else if (maxPos < car.getPosition()) {
                winnerCars.clear();
                winnerCars.add(car);
                maxPos = car.getPosition();
            }
        }
        return winnerCars;
    }
}