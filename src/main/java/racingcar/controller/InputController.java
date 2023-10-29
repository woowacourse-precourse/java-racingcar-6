package racingcar.controller;

import util.inputreader.RacingCarInputReader;

public class InputController {
    private final RacingCarInputReader racingCarInputReader;
    public InputController(){
        this.racingCarInputReader = new RacingCarInputReader();
    }

    public String readRacingCarPlayers(){
        return this.racingCarInputReader.readPlayers();
    }

    public int readTryCount(){
        return this.racingCarInputReader.readTryCount();
    }
}
