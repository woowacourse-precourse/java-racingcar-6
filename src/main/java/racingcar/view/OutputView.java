package racingcar.view;

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
}
