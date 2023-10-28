package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Commentator {

    public static List<String> getRacingState(Setting setting) {
        List<Car> cars = setting.getCars();
        List<String> states = new ArrayList<>();

        for (Car car : cars) {
            states.add(car.getName() + " : " + car.getForwardState());
        }

        return states;
    }

    public static List<String> getWinners(Setting setting) {
        List<Car> cars = setting.getCars();

        int maxDistance = 0;
        for (Car car : cars) {
            int carDistance = car.getForwardState().length();
            if (maxDistance < carDistance) {
                maxDistance = carDistance;
            }
        }

        List<String> winnerList = new ArrayList<>();
        for (Car car : cars) {
            if (car.getForwardState().length() == maxDistance) {
                winnerList.add(car.getName());
            }
        }

        return winnerList;
    }
}
