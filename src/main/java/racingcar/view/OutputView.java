package racingcar.view;

import racingcar.model.Car;

import java.util.Map;

public class OutputView {
    public static void outputCarMoveResult(Car car) {
        System.out.println("실행 결과");
        Map<String, Integer> gameDate = car.getGameDate();
        for (Map.Entry<String, Integer> carEntry : gameDate.entrySet())
            System.out.println(carEntry.getKey() + " : " + "-".repeat(carEntry.getValue()));
    }
}
