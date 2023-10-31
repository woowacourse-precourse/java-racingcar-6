package racingcar;

import racingcar.service.RaceService;

public class Controller {

    RaceService raceService = new RaceService();
    public void run(){
        //기능 1. 레이스 참가 자동차 이름 받기
        readyRace();
        raceService.raceStart();
        raceService.showWinner();
    }

    public void readyRace(){
        raceService.ParticipateRace();
        raceService.askTryCount();
    }


}
