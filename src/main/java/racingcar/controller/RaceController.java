package racingcar.controller;

import java.util.List;
import racingcar.Service.RaceService;

public class RaceController {
    RaceService raceService=new RaceService();
    public void run(){
        setRace(requestCarNames(),requestAttempts());
        startRace();
        pronounceWinner();
    }

    private void setRace(List<String>carList,int attemptsNumber) {
        raceService.setRace(carList,attemptsNumber);
    }

    private void startRace() {
        raceService.startRace();
    }

    private void pronounceWinner() {
        raceService.pronounceWinner();
    }

    private List<String> requestCarNames() {
       return raceService.requestCarNames();
    }

    private int requestAttempts() {
        return raceService.requestAttempts();
    }
}
