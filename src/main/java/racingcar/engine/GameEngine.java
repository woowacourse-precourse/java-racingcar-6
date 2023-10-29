package racingcar.engine;

import racingcar.domain.Score;

import java.util.Arrays;
import java.util.List;

public class GameEngine {
    private static final String PLAYER_NAME_DELIMITER = ",";
    private static final Long INIT_SCORE = 0L;
    private final List<Score> scores;
    private final ScoreUpdater scoreUpdater;
    private final GameEngineValidator gameEngineValidator;

    public GameEngine(String readLine, ScoreUpdater scoreUpdater, GameEngineValidator gameEngineValidator) {
        gameEngineValidator.validateIsNotNull(readLine);
        List<String> playerNames = Arrays.stream(readLine.split(PLAYER_NAME_DELIMITER)).toList();
        gameEngineValidator.validatePlayerNames(playerNames);
        this.scores = playerNames.stream().map(playerName -> new Score(playerName, INIT_SCORE)).toList();
        this.scoreUpdater = scoreUpdater;
        this.gameEngineValidator = gameEngineValidator;
    }

    public void run(String playCount) {
        gameEngineValidator.validateIsPositiveNumber(playCount);
        scoreUpdater.updateScore(scores);
    }

    public List<Score> getScores() {
        return scores;
    }

    public List<Score> getWinners() {
        Long winnerScore = scores.stream()
                .max((x, y) -> y.getScore().compareTo(x.getScore()))
                .get().getScore();
        return scores.stream()
                .filter(score -> score.getScore().equals(winnerScore))
                .toList();
    }
}
