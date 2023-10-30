package racingcar;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Print {
    public void carName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void tryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void executeInit() {
        System.out.println("실행 결과");
    }

    // todo tdd
    public void executeProgress(Map<String, Integer> carsData) {
        carsData.forEach((key, value) -> System.out.println(key + " : " + "-".repeat(Math.max(0, value))));
        System.out.println();
    }

    public void result(int maxValue, Map<String, Integer> carsData) {
        List<String> members = carsData.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == maxValue)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.print("최종 우승자 : " + String.join(",", members));
    }
}
