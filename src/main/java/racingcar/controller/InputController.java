package racingcar.controller;

import util.inputreader.CarInputReader;

public class InputController {
    private final CarInputReader carInputReader;

    public InputController() {
        this.carInputReader = new CarInputReader();
    }

    public String readCarPlayers() {
        return this.carInputReader.readPlayers();
    }

    public int readTryCount() {
        return this.carInputReader.readTryCount();
    }
}
