package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    public void printRaceStatus(Map<String, Integer> result) {
        for (String name : result.keySet()) {
            System.out.printf("%s : %s\n", name, "-".repeat(result.get(name)));
        }
        System.out.println();
    }

    public void printVictoryPlayers(List<String> victoryPlayers) {
        StringBuilder sb = new StringBuilder("최종 우승자 : ");
        for (int i = 0; i < victoryPlayers.size(); i++) {
            sb.append(victoryPlayers.get(i));
            appendSpace(victoryPlayers, sb, i);
        }
        System.out.println(sb);
    }

    private static void appendSpace(List<String> victoryPlayers, StringBuilder sb, int i) {
        if (i != victoryPlayers.size() - 1) {
            sb.append(", ");
        }
    }
}
