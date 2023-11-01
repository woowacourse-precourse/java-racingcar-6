    package tdd.service;

    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.LinkedHashMap;
    import java.util.List;
    import java.util.Map;

    public class WinnerChecker {
        public static List<String> checkWinner(LinkedHashMap<String, Integer> map) {
            List<String> winners = new ArrayList<>();
            int max = Collections.max(map.values());

            for(Map.Entry<String, Integer> entry : map.entrySet()) {
                if(entry.getValue() == max) {
                    winners.add(entry.getKey());
                }
            }
            return winners;
        }
    }
