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

    public int parseRound(String input) {
        try {
            int round = Integer.parseInt(input);
            checkRound(round);
            return round;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("라운드 수는 숫자로 입력해주세요.");
        }
    }

    // TODO: Racing#findWinner()
    // TODO : 예외 처리 고민해보기
    public String findWinner(Map<String, Integer> stateMap) {
        int farthestDistance = Collections.max(stateMap.values());
        for (Map.Entry<String, Integer> entry : stateMap.entrySet()) {
            if (entry.getValue() == farthestDistance) {
                return entry.getKey();
            }
        }
        return null;  // 모든 자동차가 0 거리인 경우
    }

    public void printWinner(String winner) {
        System.out.println("최종 우승자: " + winner);
    }

}
