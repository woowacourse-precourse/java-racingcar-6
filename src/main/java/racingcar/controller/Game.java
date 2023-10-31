package racingcar.controller;

import racingcar.model.Race;
import racingcar.view.Input;

public class Game {
    private Race race;
    public Game() {
        race = new Race();
    }

    public void gameStart(){ //게임 시작
        setRace();
        runRace();
        printRaceResult();
    }

    private void setRace() { //레이스 세팅
        race.setCarList();
        race.setRaceRounds();
    }

    private void runRace(){ //각 라운드 시작

    }

    private void printRaceResult() { //레이스 결과 출력

    }
}
