package racingcar;

import java.util.Map;
import java.util.Set;

public class ResultStringBuilder {

    public String stringBuild(Map<String, Integer> result) {
        Set<String> names = result.keySet();
        StringBuilder stringBuilder = new StringBuilder();
        for (String name : names) {
            stringBuilder.append(name)
                    .append(" : ")
                    .append(barStringBuild(result.get(name)))
                    .append("\n");
        }
        return stringBuilder.toString();
    }

    private String barStringBuild(int bars) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int bar = 0; bar < bars; bar++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }
}
