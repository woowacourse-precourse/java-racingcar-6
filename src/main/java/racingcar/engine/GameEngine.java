package racingcar.engine;

import racingcar.domain.Score;
import racingcar.generator.NumberGenerator;

import java.util.Arrays;
import java.util.List;

public class GameEngine {
    private static final String PLAYER_NAME_DELIMITER = ",";
    private static final Long INIT_SCORE = 0L;
    private final List<Score> scores;
    private final NumberGenerator numberGenerator;

    public GameEngine(String readLine, NumberGenerator numberGenerator, GameEngineValidator gameEngineValidator) {
        gameEngineValidator.validateIsNotNull(readLine);
        List<String> playerNames = Arrays.stream(readLine.split(PLAYER_NAME_DELIMITER)).toList();
        gameEngineValidator.validatePlayerNames(playerNames);
        this.scores = playerNames.stream().map(playerName -> new Score(playerName, INIT_SCORE)).toList();
        this.numberGenerator = numberGenerator;
    }

}
