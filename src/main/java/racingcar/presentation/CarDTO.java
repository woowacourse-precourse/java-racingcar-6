package racingcar.presentation;

import java.util.List;
import java.util.Map;

public class CarDTO {

    public static class ProgressResult {
        List<Map<String, Integer>> result;

        public ProgressResult(List<Map<String, Integer>> result) {
            this.result = result;
        }

        public void addResult(Map<String, Integer> middleResult) {
            result.add(middleResult);
        }

        public List<Map<String, Integer>> getResult() {
            return List.copyOf(result);
        }
    }

    public static class WinnerNames {
        List<String> names;

        public WinnerNames(List<String> names) {
            this.names = names;
        }

        public List<String> getNames() {
            return List.copyOf(names);
        }
    }
}
