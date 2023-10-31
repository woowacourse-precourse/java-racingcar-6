package racingcar.output;

import java.util.List;
import racingcar.domain.Car;

public class GameOutput {

    public void initialize() {
        System.out.println();
        System.out.println("실행결과");
    }

    public void currentStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getForwardCount(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void winners(List<String> winners) {
        if (winners.size() > 1) {
            multipleWinners(winners);
        } else if (winners.size() == 1) {
            singleWinner(winners);
        }
    }

    public void singleWinner(List<String> winner) {
        System.out.print("최종 우승자 : " + winner.get(0));
    }

    public void multipleWinners(List<String> winners) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size() - 1; i++) {
            System.out.print(winners.get(i) + ", ");
        }
        System.out.print(winners.get(winners.size() - 1));
    }
}
