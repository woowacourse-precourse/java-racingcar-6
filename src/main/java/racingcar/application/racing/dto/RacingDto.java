package racingcar.application.racing.dto;

import java.util.Map;

public class RacingDto {
    private Map<String, Integer> racingCarMap;
    private int gameCnt;

    public void setRacingCar(Map<String, Integer> racingCarMap) {
        this.racingCarMap = racingCarMap;
    }

    public Map<String, Integer> getRacingCarMap() {
        return this.racingCarMap;
    }

    public void setGameCnt(int gameCnt) {
        this.gameCnt = gameCnt;
    }

    public int getGameCnt() {
        return this.gameCnt;
    }
}
