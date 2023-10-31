package racingcar.domain;

import java.util.List;

public class Result {
    private List<Car> winnerList;
    public static void printRaceResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.printf("%s : %s\n", car.getName(), car.getState());
        }
        System.out.println();
    }

    public void printWinner() {

    }

}
