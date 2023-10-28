package racingcar.view;

import racingcar.model.Car;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void outputCarMoveResult(Car car) {
        System.out.println("실행 결과");
        List<String> carNames = car.getCarName();
        List<Integer> carPositions = car.getCarPosition();

        for (int i=0; i<carNames.size(); i++) {
            System.out.println(carNames.get(i) + " : " + "-".repeat(carPositions.get(i)));
        }
    }

    public static void outputWinnerResult(Car car, List<Integer> winnerIndex) {
        System.out.print("최종 우승자 : ");

        System.out.print(car.getCarName().get(winnerIndex.get(0)));
        for (int i=1; i<winnerIndex.size(); i++) {
            System.out.print(", " + car.getCarName().get(i));
        }



    }
}
