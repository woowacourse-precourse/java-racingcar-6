package app.controller;

import app.domain.Race;
import app.service.RaceService;

public class RaceController {

    private final RaceService raceService = new RaceService();

    public Race getRace() {
        return raceService.getCarName();
    }
    public int getRaceCount() {
        return raceService.getRaceCount();
    }

    public void game(Race raceList, int raceCount) {
        System.out.println("\n실행 결과");

        for (int i = 0; i < raceCount; i++) {
            raceList.play();
            raceList.printPlay();
        }
    }

    public void getResult(Race raceList) {
        int max = raceList.getMaxNum();
        String[] winner = raceList.getWinner(max);

        System.out.println("최종 우승자 : " + String.join(", ", winner));
    }
}
