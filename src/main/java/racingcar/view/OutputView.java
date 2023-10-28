package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void appendRaceStatus(StringBuilder sb, Map<String, Integer> result) {
        for (String name : result.keySet()) {
            sb.append(name)
                    .append(" : ")
                    .append("-".repeat(result.get(name)))
                    .append("\n");
        }
        sb.append("\n");
    }

    public void printRaceStatus(StringBuilder sb) {
        System.out.println(sb.toString());
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
