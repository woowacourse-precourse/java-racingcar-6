package racingcar.view;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class OutputView {
    public void printRacingStartMessage() {
        System.out.println("실행결과");
    }

    public void printRoundResult(List<String> carsName, Map<String, Integer> CarsScore) {
        carsName.forEach(carName -> printCarScore(carName, CarsScore.get(carName)));
        System.out.println();
    }

    public void printWinner(List<String> winner) {
        System.out.println(makeWinnersMessage(winner));
    }

    private String makeWinnersMessage(List<String> winner) {
        Iterator<String> iterator = winner.iterator();
        StringBuilder sb = new StringBuilder("최종 우승자 : " + iterator.next());
        while(iterator.hasNext()) {
            sb.append(", ");
            sb.append(iterator.next());
        }
        return sb.toString();
    }


    private void printCarScore(String carName, int carScore) {
        System.out.println(carName + " : " + "-".repeat(carScore));
    }


}
