package racingcar.application.racing.dto;

import java.util.Map;

public class RacingDto {
    private Map<String, Integer> carMap;
    private int gameCnt;

    public void setRacingCar(Map<String, Integer> carMap) {
        this.carMap = carMap;
    }

    public Map<String, Integer> getCarMap() {
        return this.carMap;
    }

    public void setGameCnt(int gameCnt) {
        this.gameCnt = gameCnt;
    }

    public int getGameCnt() {
        return this.gameCnt;
    }
}
