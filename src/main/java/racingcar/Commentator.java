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
        List<String> winnerList = new ArrayList<>();
        int maxDistance = 0;

        for (Car car : cars) {
            int carDistance = car.getForwardState().length();
            if (maxDistance < carDistance) {
                maxDistance = carDistance;
                winnerList.clear();
                winnerList.add(car.getName());
            } else if (maxDistance == carDistance){
                winnerList.add(car.getName());
            }
        }

        return winnerList;
    }
}
