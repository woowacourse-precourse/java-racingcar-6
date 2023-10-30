package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Map<String, Integer> status = Input.getInitialStatus();
        int count = Input.getCount();
        Game.play(status, count);

        for (int i=0; i<count; i++) {
            for(Map.Entry<String, Integer> entry: status.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                System.out.println(key + " : " + "-".repeat(value));
            }
            System.out.println();
        }
        // Game에서 result 받아서 출력
        int max = status.values().stream().max(Integer::compare).orElse(-1);
        List<String> winners = status.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == max)
                .map(Map.Entry::getKey)
                .toList();

        System.out.println("최종 우승자 : " + String.join(",", winners));
    }
}
