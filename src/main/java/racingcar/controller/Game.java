package racingcar.controller;

import racingcar.model.Race;

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

    }

    private void runRace(int rounds){ //각 라운드 시작

    }

    private void printRaceResult() { //레이스 결과 출력

    }
}
