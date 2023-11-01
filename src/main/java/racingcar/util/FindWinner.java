package racingcar.util;

import racingcar.model.Car;
import java.util.ArrayList;
import java.util.List;

public class FindWinner {

    static int maxPosition = 0;
    static List<Car> winnerList;

    public static void dataInit() {
        maxPosition = 0;
        winnerList = new ArrayList<>();
    }

    public static List<Car> getWinnerList(List<Car> carList) {

        dataInit();

        for (Car car : carList) {
            isMaxPosition(car.getPosition());
        }

        return winnerList;
    }

    public static void isMaxPosition(int position) {

        if (position > maxPosition) {
            maxPosition = position;
        }

    }

    public static int getMaxPosition() {
        return maxPosition;
    }

}
