package racingcar.domain;

import racingcar.dto.RaceProgressDTO;

public interface Billboard {
    void displayRaceProgress(RaceProgressDTO raceProgress);
    void displayWinners(WinnerStand winnerStand);
}
