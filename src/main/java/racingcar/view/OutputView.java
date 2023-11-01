package racingcar.view;

import racingcar.domain.Car;
import java.util.List;

public class OutputView {

    public void printWinners(List<Car> winners) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).toString());
            if (i < winners.size() - 1) {
                System.out.print(", ");
            } else {
                System.out.println();
            }
        }
    }

    public void printRoundResult() {
        System.out.println("실행결과");
    }
    public void printBlank() {
        System.out.println("");
    }
}
