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
}
