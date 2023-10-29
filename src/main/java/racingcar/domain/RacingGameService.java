package racingcar.domain;

import racingcar.controller.dto.WinnerDto;

public interface RacingGameService {

    void playRound(final Cars cars);

    WinnerDto findWinner(final Cars cars);
}
