package racingcar;

import racingcar.game.RacingDirector;
import racingcar.game.RacingSimulator;
import racingcar.game.Rule;
import racingcar.game.inputgenerateManager.InputGenerateManagerImpl;
import racingcar.game.outputgeneratemanager.OutputGenerateManager;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Rule rule = new Rule();
        InputGenerateManagerImpl inputGenerateManager = new InputGenerateManagerImpl();
        OutputGenerateManager outputGenerateManager = new OutputGenerateManager(rule);
        RacingSimulator racingSimulator = new RacingSimulator(inputGenerateManager);
        RacingDirector racingDirector = new RacingDirector(inputGenerateManager,outputGenerateManager, racingSimulator);
        racingDirector.startProcess();
    }
}
