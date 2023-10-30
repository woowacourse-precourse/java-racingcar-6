package racingcar;

import java.util.HashMap;
import java.util.Set;

public class ResultStringBuilder {

    public String stringBuild(HashMap<String, Integer> result) {
        Set<String> key = result.keySet();
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : key) {
            stringBuilder.append(s)
                    .append(" : ")
                    .append(barStringBuild(result.get(s)))
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
