package racingcar.view;

import racingcar.model.Car;
import racingcar.utils.StringUtils;

import java.util.List;

public class OutputView {
    private static final String STEP = "-";
    private static final String COLON = " : ";
    private static final String WINNER = "최종 우승자";

    public void printEachRacingResult(List<Car> cars, int size) {
        for (int i = 0; i < size; i++) {
            Car car = cars.get(i);
            System.out.println(car.getCarName() + COLON + StringUtils.repeatString(STEP, car.getCarPosition()));
        }
        System.out.println();
    }

    public void printWinners(String winners) {
        System.out.println(WINNER + COLON + winners);
    }
}