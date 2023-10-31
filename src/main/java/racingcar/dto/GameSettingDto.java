package racingcar.dto;

import java.util.List;

public class GameSettingDto {
    private List<String> carNames;
    private int tryCount;

    public GameSettingDto(List<String> carNames, int tryCount) {
        this.carNames = carNames;
        this.tryCount = tryCount;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getTryCount() {
        return tryCount;
    }
}
