package racingcar;

import app.controller.RaceController;
import app.domain.Race;

public class Application {

    private static final RaceController raceController = new RaceController();

    public static void main(String[] args) {
        // 경주할 자동차를 입력받음
        Race raceList = raceController.getRace();

        // 경기횟수를 입력받음
        int raceCount = raceController.getRaceCount();
        
        // 게임시작
        raceController.game(raceList, raceCount);

        // 게임결과 출력
        raceController.getResult(raceList);
    }
}
