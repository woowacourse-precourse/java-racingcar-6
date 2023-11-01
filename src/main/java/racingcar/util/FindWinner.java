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

        for (Car car : carList) {
            isWinner(car);
        }

        return winnerList;
    }

    public static void isMaxPosition(int position) {

        if (position > maxPosition) {
            maxPosition = position;
        }

    }

    public static void isWinner(Car car) {

        if (car.getPosition() == maxPosition) {
            winnerList.add(car);
        }

    }

    public static int getMaxPosition() {
        return maxPosition;
    }

    public static List<Car> getWinnerList() {
        return winnerList;
    }

}
