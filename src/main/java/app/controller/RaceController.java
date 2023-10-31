package app.controller;

import app.domain.Race;
import app.service.RaceService;

public class RaceController {

    private static final RaceService raceService = new RaceService();

    public static void run() {
        // 경주할 자동차를 입력받음
        Race raceList = raceService.getCarName();

        // 경기횟수를 입력받음
        int raceCount = raceService.getRaceCount();

        // 게임시작
        raceService.game(raceList, raceCount);

        // 게임결과 출력
        raceService.getResult(raceList);
    }
}
