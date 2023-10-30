package racingcar.Service;

import racingcar.Domain.Car;
import racingcar.Domain.Race;
import racingcar.Domain.RacingCars;

public class RaceService {
    private Race race;

    public void inputRaceCount(int raceCount) {
        this.race = new Race(raceCount);
    }



    public boolean isRaceOver(int currentRace) {
        // 경주가 종료되었는지 확인하는 메서드를 호출
        return race.isRaceOver(currentRace);
    }
}

