package racingcar.Service;

import racingcar.Domain.Race;
import racingcar.Domain.RacingCars;

public class RaceService {
    private Race race;

    public Race inputRaceCount(int raceCount) {
        this.race = new Race(raceCount);
        return race;
    }



    public boolean isRaceOver(int currentRace) {
        // 경주가 종료되었는지 확인하는 메서드를 호출
        return race.isRaceOver(currentRace);
    }
}

