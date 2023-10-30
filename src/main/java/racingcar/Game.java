package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.Map;

// 게임 진행하는 클래스
public class Game {
    public static void play(Map<String, Integer> status, int count) {
        System.out.println("실행 결과");
        for (int i=0; i<count; i++) {
            for (Map.Entry<String, Integer> entry : status.entrySet()) {
                int random = pickNumberInRange(0, 9);
                if (random >= 4) {
                    entry.setValue(entry.getValue() + 1);
                }
            }
            Result.showMiddle(status);
        }
    }

}
