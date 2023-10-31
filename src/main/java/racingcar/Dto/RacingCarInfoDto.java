package racingcar.Dto;

import java.util.List;

public class RacingCarInfoDto {
    private List<String> carNames;
    private int racingCount;

    public List<String> getCarNames() {
        return carNames;
    }

    public void setCarNames(List<String> carNames) {
        this.carNames = carNames;
    }

    public int getRacingCount() {
        return racingCount;
    }

    public void setRacingCount(int racingCount) {
        this.racingCount = racingCount;
    }

    public int getRacingCarCount() {
        return carNames.size();
    }
}
