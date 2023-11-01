package racingcar;

import racingcar.game.Simulator;

public class Application {
    public static void main(String[] args) {
        Simulator simulator = new Simulator();

        simulator.getUserInput();
        simulator.simulateSeveralTimes();
        simulator.printWinners();
    }
}
