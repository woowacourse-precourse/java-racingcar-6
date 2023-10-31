package racingcar;

import basis.MovingStatus;
import basis.Race;
import basis.WinnerResult;
import io.UserInput;

public class Application {
    public static void main(String[] args) {
        MovingStatus movingStatus = new MovingStatus();
        WinnerResult winnerResult = new WinnerResult();
        UserInput ui = new UserInput();
        Race race = new Race(movingStatus, winnerResult, ui);
        race.run();
    }
}