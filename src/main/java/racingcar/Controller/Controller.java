package racingcar.Controller;

import racingcar.Model.Scoreboard;
import racingcar.Model.Settings;

public class Controller {
    Scoreboard scoreboard = new Scoreboard();
    Settings settings = new Settings();

    public void requestCarGenerate(String[] names) {
        scoreboard.createAndAddCars(names);
    }

    public void requestSetAttempts(int attempts) {
        settings.setAttempts(attempts);
    }

}
