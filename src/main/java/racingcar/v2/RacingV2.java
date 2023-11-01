package racingcar.v2;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class RacingV2 {
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

    public void checkRound(int round) {
        if (round <= 0) {
            throw new IllegalArgumentException("라운드 수는 1 이상이어야 합니다.");
        }
    }

    // TODO: Racing#findWinner()
    // TODO : 예외 처리 고민해보기
    public String findWinner(Map<String, Integer> stateMap) {
        int farthestDistance = Collections.max(stateMap.values());
        List<String> winners = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : stateMap.entrySet()) {
            if (entry.getValue() == farthestDistance) {
                winners.add(entry.getKey());
            }
        }
        return String.join(", ", winners);
    }

    public void printState(Map<String, Integer> stateMap) {
        for (Map.Entry<String, Integer> entry : stateMap.entrySet()) {
            String carName = entry.getKey();
            int position = entry.getValue();
            System.out.println(carName + " : " + "-".repeat(position));
        }
        System.out.println();
    }


    public void printWinner(String winner) {
        System.out.println("최종 우승자 : " + winner);

    }

}
