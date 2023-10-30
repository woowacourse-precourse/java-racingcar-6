package racingcar.domain;

public interface RacingGameService {

    GameResult startGame(final Cars cars, final int tryCount);

    void playRound(final Cars cars, final GameResult gameResult);

    Winner findWinner(final Cars cars);
}
