package racingcar.model;

public class GameSettingsDto {
    private String carsName;
    private int racingCount;

    public GameSettingsDto(String carsName, int racingCount){
        this.carsName = carsName;
        this.racingCount = racingCount;
    }

    public String getCarsName(){
        return carsName;
    }

    public int getRacingCount(){
        return racingCount;
    }
}
