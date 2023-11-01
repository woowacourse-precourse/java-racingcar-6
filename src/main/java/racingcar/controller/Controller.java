package racingcar.controller;

import racingcar.service.Simulator;
import racingcar.view.Input;
import racingcar.view.Output;

public class Controller {
    private final Simulator simulator = new Simulator();
    public void run() {
        initRace();
        startRace();
    }

    public void initRace() {
        String carNameInput = Input.carInputMessage();
        int trialInput = Input.moveInputMessage();
        simulator.setRace(carNameInput, trialInput);
    }

    public void startRace() {
        Output.printEmptySpace();
        Output.displayRaceProgressMessage();
        Output.displayRaceWinner(simulator.startRace());
    }
}
