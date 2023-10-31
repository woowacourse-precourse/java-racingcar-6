package racingcar;

import racingcar.engine.GameEngine;
import racingcar.engine.GameEngineValidator;
import racingcar.engine.ScoreUpdater;
import racingcar.generator.NumberGenerator;
import racingcar.generator.RandomNumberGenerator;
import racingcar.reader.InputReader;
import racingcar.reader.NextStepInputReader;
import racingcar.ui.Ui;

public class AppConfig {
    public GameEngine getGameEngine() {
        return new GameEngine(getScoreUpdater(), getGameEngineValidator());
    }

    public ScoreUpdater getScoreUpdater() {
        return new ScoreUpdater(getNumberGenerator());
    }

    public NumberGenerator getNumberGenerator() {
        return new RandomNumberGenerator();
    }

    public GameEngineValidator getGameEngineValidator() {
        return new GameEngineValidator();
    }

    public Ui getUi() {
        return new Ui();
    }

    public InputReader getInputReader() {
        return new NextStepInputReader();
    }
}
