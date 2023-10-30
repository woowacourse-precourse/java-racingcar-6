package racingcar.view;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import racingcar.vo.Car;

public class ResultView {

    public ResultView() {
        System.out.println("실행결과");
    }

    public void showRacingResult(Map<Car, List<Integer>> positionHistory, int attempt) {
        for (int i = 0; i < attempt; i++) {
            for (Entry<Car, List<Integer>> racing : positionHistory.entrySet()) {
                Car car = racing.getKey();
                List<Integer> position = racing.getValue();
                showRacingResultPrint(car, position.get(i));
            }
            System.out.println("");
        }
    }

    private void showRacingResultPrint(Car car, int position) {
        System.out.print(car.getName() + ":");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }
}
