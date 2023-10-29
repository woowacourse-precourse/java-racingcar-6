package racingcar.engine;

import racingcar.domain.Score;
import racingcar.generator.NumberGenerator;

import java.util.Arrays;
import java.util.List;

public class GameEngine {
    private static final String PLAYER_NAME_DELIMITER = ",";
    private static final Long INIT_SCORE = 0L;
    private static final Long PLUS_SCORE = 1L;
    private static final int NUMBER_GENERATOR_START_INCLUSIVE = 0;
    private static final int NUMBER_GENERATOR_END_INCLUSIVE = 9;
    private static final int ADD_SCORE_POINT = 4;
    private final List<Score> scores;
    private final NumberGenerator numberGenerator;
    private final GameEngineValidator gameEngineValidator;

    public GameEngine(String readLine, NumberGenerator numberGenerator, GameEngineValidator gameEngineValidator) {
        gameEngineValidator.validateIsNotNull(readLine);
        List<String> playerNames = Arrays.stream(readLine.split(PLAYER_NAME_DELIMITER)).toList();
        gameEngineValidator.validatePlayerNames(playerNames);
        this.scores = playerNames.stream().map(playerName -> new Score(playerName, INIT_SCORE)).toList();
        this.numberGenerator = numberGenerator;
        this.gameEngineValidator = gameEngineValidator;
    }

    public void run(String playCount) {
        gameEngineValidator.validateIsPositiveNumber(playCount);
        long playEndTime = Long.parseLong(playCount);
        for (long playTime = 0; playTime < playEndTime; playTime++) {
            updateScore();
        }
    }

    private void updateScore() {
        for (Score score : scores) {
            if (numberGenerator.generate(NUMBER_GENERATOR_START_INCLUSIVE, NUMBER_GENERATOR_END_INCLUSIVE) < ADD_SCORE_POINT)
                continue;
            score.addScore(PLUS_SCORE);
        }
    }
}
