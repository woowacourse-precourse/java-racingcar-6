package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printRacingStartMessage() {
        System.out.println("실행결과");
    }

    public void printRoundResult(List<String> carsName, Map<String, Integer> CarsScore) {
        carsName.forEach(carName -> printCarScore(carName, CarsScore.get(carName)));
    }

    private void printCarScore(String carName, int carScore) {
        System.out.println(carName + " : " + "-".repeat(carScore) +'\n');
    }
}
