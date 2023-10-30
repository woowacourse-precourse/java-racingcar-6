package racingcar.view;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import racingcar.vo.Car;

public class ResultView {

    public ResultView() {
        System.out.println("실행결과");
    }

    public void RacingResult(Map<Car, List<Integer>> positionHistory, int attempt) {
        for (int i = 0; i < attempt; i++) {
            for (Entry<Car, List<Integer>> racing : positionHistory.entrySet()) {
                Car car = racing.getKey();
                List<Integer> position = racing.getValue();
                showRacingResult(car, position.get(i));
            }
            System.out.println("");
        }
    }

    private void showRacingResult(Car car, int position) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }

    public void showRacingWinners(List<String> winners) {
        String names = String.join(",", winners);
        System.out.println("최종 우승자 : " + names);
    }

}
