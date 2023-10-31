package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {

    public void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    public void printRaceStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.printf("%s : %s\n", car.getName(), "-".repeat(car.getMove()));
        }
        System.out.println();
    }

    public void printVictoryPlayers(List<String> victoryPlayers) {
        System.out.printf("최종 우승자 : %s", String.join(", ", victoryPlayers));
    }
}
