package racingcar.controller;

import util.inputreader.RacingCarInputReader;

public class InputController {
    private final RacingCarInputReader racingCarInputReader;
    public InputController(){
        this.racingCarInputReader = new RacingCarInputReader();
    }

    public String inputRacingCarPlayers(){
        return this.racingCarInputReader.inputPlayers();
    }

    public int getTryCount(){
        return this.racingCarInputReader.inputTryCount();
    }
}
