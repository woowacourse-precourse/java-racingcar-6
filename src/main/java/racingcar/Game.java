package racingcar;

import java.util.Map;

// 게임 진행하는 클래스
public class Game {
    public static Map<String, Integer> play(Map<String, Integer> status, int count) {
        System.out.println("실행 결과");
        for (int i=0; i<count; i++) {
            Progress.takeProgress(status);
            Result.showMiddle(status);
        }
        return status;
    }

}
