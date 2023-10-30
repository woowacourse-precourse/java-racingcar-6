package racingcar;

import java.util.Map;

public class ResultGenerator {
    public String generateResult(Map<String, Integer> result) {
        StringBuilder sb = new StringBuilder();
        for (String carName : result.keySet()) {
            sb.append(carName).append(" : ");
            for (int i = 0; i < result.get(carName); i++) {
                sb.append("-");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}