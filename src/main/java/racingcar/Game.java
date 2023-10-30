package racingcar;

import racingcar.view.Announcer;
import racingcar.view.Viewer;

public class Game {
    private final Announcer announcer;
    private final CarGenerator carGenerator;
    private final RandomNumberGenerator randomNumberGenerator;
    private final Viewer viewer;

    public Game(Announcer announcer, CarGenerator carGenerator, RandomNumberGenerator randomNumberGenerator,
                Viewer viewer) {
        this.announcer = announcer;
        this.carGenerator = carGenerator;
        this.randomNumberGenerator = randomNumberGenerator;
        this.viewer = viewer;
    }

}
