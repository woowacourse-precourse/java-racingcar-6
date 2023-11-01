package racingcar.view;

import java.util.List;
import racingcar.domain.Racer;

public class OutputView {
    public void printInitialPositions(List<Racer> racers) {
        System.out.println("초기 자동차 위치:");
        for (Racer racer : racers) {
            System.out.println(racer.getName() + " : -");
        }
    }

    public void printPositions(List<Racer> racers) {
        System.out.println("자동차 위치:");
        for (Racer racer : racers) {
            StringBuilder positionString = new StringBuilder(racer.getName() + " : ");
            for (int i = 0; i < racer.getPosition(); i++) {
                positionString.append("-");
            }
            System.out.println(positionString.toString());
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.print("최종 우승자: ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
