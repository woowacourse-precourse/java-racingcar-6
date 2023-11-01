package racingcar.model;

import java.util.List;

public class GameSettingsDto {
    private List<String> carsName;
    private int racingCount;

    public GameSettingsDto(List<String> carsName, int racingCount){
        this.carsName = carsName;
        this.racingCount = racingCount;
    }

    public List<String> getCarsName(){
        return carsName;
    }

    public int getRacingCount(){
        return racingCount;
    }
}
