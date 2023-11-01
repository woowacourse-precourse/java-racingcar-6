package racingcar.domain.game.service;

import racingcar.domain.car.Cars;
import racingcar.domain.game.GameResult;
import racingcar.domain.game.Trial;
import racingcar.domain.game.Winner;

public interface RacingGameService {

    GameResult startGame(final Cars cars, final Trial trial);

    void playRound(final Cars cars, final GameResult gameResult);

    Winner findWinner(final Cars cars);
}
