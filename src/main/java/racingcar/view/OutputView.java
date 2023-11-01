package racingcar.view;

import java.util.List;
import racingcar.domain.Racer;

public class OutputView {

    public void printResult() {
        System.out.println("실행 결과");
    }

    public void printPositions(List<Racer> racers) {
        for (Racer racer : racers) {
            StringBuilder positionString = new StringBuilder(racer.getName() + " : ");
            for (int i = 0; i < racer.getPosition(); i++) {
                positionString.append("-");
            }
            System.out.println(positionString);
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
