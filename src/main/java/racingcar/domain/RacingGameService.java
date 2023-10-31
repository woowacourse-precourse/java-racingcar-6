package racingcar.domain;

public interface RacingGameService {

    GameResult startGame(final Cars cars, final Trial trial);

    void playRound(final Cars cars, final GameResult gameResult);

    Winner findWinner(final Cars cars);
}
