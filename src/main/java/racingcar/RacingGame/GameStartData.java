package racingcar.RacingGame;

import java.util.ArrayList;
import java.util.List;

public class GameStartData { // 게임이 시작하면 작성할 곳

    List<String> userNames = new ArrayList<>(); // 유저 이름 저장
    int userIteration; // 반복 회수 저장

    public GameStartData(List<String> userNames, int userIteration) { // 생성자
        this.userNames = userNames;
        this.userIteration = userIteration;
    }

}
