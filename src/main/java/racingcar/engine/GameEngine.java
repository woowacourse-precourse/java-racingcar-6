package racingcar.engine;

import racingcar.domain.Score;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class GameEngine {
    private static final String PLAYER_NAME_DELIMITER = ",";
    private static final Long INIT_SCORE = 0L;
    private final static String SCORES_NULL_POINTER_EXCEPTION_MESSAGE = "플레이어 생성 먼저해주세요.";
    private final ScoreUpdater scoreUpdater;
    private final GameEngineValidator gameEngineValidator;
    private List<Score> scores;

    public GameEngine(ScoreUpdater scoreUpdater, GameEngineValidator gameEngineValidator) {
        this.scoreUpdater = scoreUpdater;
        this.gameEngineValidator = gameEngineValidator;
    }

    public void initScore(String readLine) {
        if (scores != null)
            return;
        gameEngineValidator.validateIsNotNull(readLine);
        List<String> playerNames = Arrays.stream(readLine.split(PLAYER_NAME_DELIMITER)).toList();
        gameEngineValidator.validatePlayerNames(playerNames);
        this.scores = playerNames.stream().map(playerName -> new Score(playerName, INIT_SCORE)).toList();
    }

    public void validatePlayCount(String playCount) {
        gameEngineValidator.validateIsPositiveNumber(playCount);
    }

    public void run() {
        validateScoreIsNotNull();
        scoreUpdater.updateScore(scores);
    }

    private void validateScoreIsNotNull() {
        if (scores == null)
            throw new NullPointerException(SCORES_NULL_POINTER_EXCEPTION_MESSAGE);
    }

    public List<Score> getScores() {
        validateScoreIsNotNull();
        return scores;
    }

    public List<Score> getWinners() {
        validateScoreIsNotNull();
        Long winnerScore = scores.stream()
                .max(Comparator.comparing(Score::getScore))
                .get().getScore();
        return scores.stream()
                .filter(score -> score.getScore().equals(winnerScore))
                .toList();
    }
}
