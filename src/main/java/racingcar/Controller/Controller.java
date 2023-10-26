package racingcar.Controller;

import racingcar.Model.Scoreboard;

public class Controller {
    Scoreboard scoreboard = new Scoreboard();

    public void requestCarGenerate(String[] names) {
        scoreboard.createAndAddCars(names);
    }

}
