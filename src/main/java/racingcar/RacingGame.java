package racingcar;

import racingcar.game.car.CarFactory;
import racingcar.game.director.Director;
import racingcar.game.director.Rule;
import racingcar.game.director.Simulator;
import racingcar.game.inputgenerateManager.InputGenerateManager;
import racingcar.game.inputgenerateManager.InputGenerateManagerImpl;
import racingcar.game.outputgeneratemanager.OutputGenerateManager;

public class RacingGame {

    private final Director director;

    private RacingGame() {
        Rule rule = new Rule();
        InputGenerateManager inputGenerateManager = new InputGenerateManagerImpl();
        OutputGenerateManager outputGenerateManager = new OutputGenerateManager(rule);
        Simulator simulator = new Simulator();
        CarFactory carFactory = new CarFactory(inputGenerateManager);
        this.director = new Director(inputGenerateManager, outputGenerateManager, simulator, carFactory);
    }

    public RacingGame(Director director) {
        this.director = director;
    }

    public void start() {
        director.startProcess();
    }

    public static RacingGame createGame() {
        return new RacingGame();
    }

}
