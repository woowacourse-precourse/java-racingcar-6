package racingcar;

import java.util.List;

public class Utils {

    static void checkNameOverFive(List<Car> names) {
        for(Car car : names) {
            if (car.getName().length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    static String makeLane(int position) {
        StringBuilder lane = new StringBuilder();
        while(position-- > 0) {
            lane.append("-");
        }
        return lane.toString();
    }
}
