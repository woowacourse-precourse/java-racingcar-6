package racingcar.domain;

import racingcar.dto.RaceProgressDTO;

public interface Billboard {

    void displayraceprogress(RaceProgressDTO raceProgressDTO);

    void displayWinners(WinnerStand winnerStand);
}
