package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    public void executeProgress(Map<String, Integer> carNames) {
        for (Map.Entry<String, Integer> result : carNames.entrySet()) {
            System.out.println(result.getKey() + " : " + "-".repeat(Math.max(0, result.getValue())));
        }
        System.out.println();
    }

    public void result(int tryCount, Map<String, Integer> carNames) {
        // value 비교 -> 가장 큰 수 -> 가장 큰 value를 가진 녀석들 print
        // 최대값은 정해짐 -> 역순으로 그 값을 가진 녀석 contains로 찾기  (√)
        int maxValue = 0;
        for (int i = tryCount; i > 0; i--) {
            if (!carNames.containsValue(i)) continue;
            maxValue = i;
            break;
        }

        List<String> members = new ArrayList<>();
        for (Map.Entry<String, Integer> car : carNames.entrySet()) {
            if (car.getValue() == maxValue) {
                members.add(car.getKey());
            }
        }

        System.out.print("최종 우승자 : " + String.join(",", members));
    }
}
