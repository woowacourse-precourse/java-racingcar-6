package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        // User Input 받기
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] cars = readLine().split(",");
        System.out.println("시도할 회수는 몇회인가요?");
        int count = Integer.parseInt(readLine());

        Map<String, Integer> status = Stream.of(cars).collect(Collectors.toMap(car -> car, car -> 0));

        for (Map.Entry<String, Integer> entry: status.entrySet()) {
            String car = entry.getKey();
            if (car.length() > 5) {
                throw new IllegalArgumentException("자동차 이름이 5자를 넘습니다.");
            }
        }

        // Input으로 게임 진행
        System.out.println("실행 결과");
        for (int i=0; i<count; i++) {
            for (Map.Entry<String, Integer> entry : status.entrySet()) {
                int random = pickNumberInRange(0, 9);
                if (random >= 4) {
                    entry.setValue(entry.getValue() + 1);
                }
            }
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
