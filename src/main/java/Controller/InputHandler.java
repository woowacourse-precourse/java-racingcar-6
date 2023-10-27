package Controller;

import Model.RaceCarNames;
import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    RaceCarNames raceCarNames;

    public void receiveRaceCarNames() {
        String input = Console.readLine();
        raceCarNames = new RaceCarNames(input);
    }

    public RaceCarNames getRaceCarNames() {
        return raceCarNames;
    }
}
