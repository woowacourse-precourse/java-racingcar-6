package racingcar.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {
    private static final int MOVING_FORWARD = 4;

    public Map<String, Integer> startEachGame(Map<String, Integer> memberStates) {
        // 한 차수씩 시작
        for (String name : memberStates.keySet()) {

            // 무작위 값 뽑기
            int randomNumber = Randoms.pickNumberInRange(0, 9);

            // 전진할 경우
            if (randomNumber >= MOVING_FORWARD) {
                memberStates.replace(name, memberStates.get(name) + 1);
            }
        }
        return memberStates;
    }

    // 이동거리를 대쉬(-)로 변경
    public StringBuilder changeDash(int distance) {
        StringBuilder stringBuilder = new StringBuilder();
        String dash = "-";
        for (int i = 0; i < distance; i++) {
            stringBuilder.append(dash);
        }

        return stringBuilder;
    }

    public List<String> getWinner(Map<String, Integer> memberStates) {
        // 최종 우승자 결정

        // 최대 이동값 구하기
        int maxNumber = getMaxNumber(memberStates);
        List<String> winner = new ArrayList<>();
        for (String name : memberStates.keySet()) {
            if (memberStates.get(name) == maxNumber) {
                winner.add(name);
            }
        }

        return winner;
    }

    public int getMaxNumber(Map<String, Integer> memberStates) {
        int maxNumber = 0;
        for (String name : memberStates.keySet()) {
            if (memberStates.get(name) > maxNumber) {
                maxNumber = memberStates.get(name);
            }
        }
        return maxNumber;
    }
}
