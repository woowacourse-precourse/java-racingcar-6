package racingcar.domain;

import racingcar.controller.dto.WinnerDto;

public interface RacingGameService {

    GameResult startGame(final Cars cars, final int tryCount);

    void playRound(final Cars cars, final GameResult gameResult);

    WinnerDto findWinner(final Cars cars);
}
