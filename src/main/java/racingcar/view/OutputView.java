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
        StringBuilder sb = new StringBuilder("최종 우승자 : ");
        for (int i = 0; i < victoryPlayers.size(); i++) {
            sb.append(victoryPlayers.get(i));
            appendComma(victoryPlayers, sb, i);
        }
        System.out.println(sb);
    }

    private static void appendComma(List<String> victoryPlayers, StringBuilder sb, int i) {
        if (i != victoryPlayers.size() - 1) {
            sb.append(", ");
        }
    }
}
