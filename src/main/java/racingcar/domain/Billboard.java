package racingcar.domain;

import racingcar.dto.RaceProgressDTO;

public interface Billboard {

    void displayRaceProgress(RaceProgressDTO raceProgressDTO);

    void displayWinners(WinnerStand winnerStand);
}
