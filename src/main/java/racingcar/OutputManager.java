package racingcar;

import java.util.List;

public class OutputManager {
    public void printRaceResult(List<Car> cars) {
        System.out.println("실행 결과");
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        System.out.print("최종 우승자 : ");

        StringBuilder winnerNames = new StringBuilder();
        for (int i = 0; i < winners.size(); i++) {
            Car winner = winners.get(i);
            winnerNames.append(winner.getName());

            if (i < winners.size() - 1) {
                winnerNames.append(", ");
            }
        }

        System.out.println(winnerNames);
    }
}
