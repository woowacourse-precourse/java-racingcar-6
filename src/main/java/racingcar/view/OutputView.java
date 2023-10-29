package racingcar.view;


import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;

public class OutputView {
    // "-" 기호를 통해 얼마나 갔는지 RacingRoad 보여주기
    // Winner 보여주기
    private static final String RACING_ROAD = "-";
    private static int maxPosition;


    public static void printRacingStatus(String carName, int position) {
        System.out.print(carName + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print(RACING_ROAD);
        }
        System.out.println();
    }

    private static void judgeWinner() {
        maxPosition = 0;
        for (Car car : Cars.cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
    }
}
