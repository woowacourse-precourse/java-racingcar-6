package racingcar.v2;

import camp.nextstep.edu.missionutils.Console;

import java.util.Collections;
import java.util.Map;

public class Racing {
    // TODO: 시도 횟수 예외 처리. 숫자가 아닌 값, 음수 값, 0 값, 제한 횟수 초과.
    public int Round() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    // TODO: Racing#findWinner()
    public void findWinner(Map<String, Integer> stateMap) {
        int farthestDistance = Collections.max(stateMap.values());
        String winner = "";
        for (Map.Entry<String, Integer> entry : stateMap.entrySet()) {
            if (entry.getValue() == farthestDistance) {
                winner = entry.getKey();
                break;
            }
        }
        System.out.println("최종 우승자: " + winner);
    }

}
