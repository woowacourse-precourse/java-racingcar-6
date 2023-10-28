package racingcar;

import racingcar.game.Director;
import racingcar.game.Simulator;
import racingcar.game.Rule;
import racingcar.game.inputgenerateManager.InputGenerateManagerImpl;
import racingcar.game.outputgeneratemanager.OutputGenerateManager;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Rule rule = new Rule();
        InputGenerateManagerImpl inputGenerateManager = new InputGenerateManagerImpl();
        Simulator simulator = new Simulator(inputGenerateManager);
        OutputGenerateManager outputGenerateManager = new OutputGenerateManager(rule);
        Director director = new Director(inputGenerateManager,outputGenerateManager, simulator);
        director.startProcess();
    }
}
