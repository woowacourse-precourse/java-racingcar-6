package racingcar.dto;

public class PerGameCarResultDto {
    private String carName;
    private int moveCnt;
    
    public PerGameCarResultDto(String carName, int moveCnt){
        this.carName = carName;
        this.moveCnt = moveCnt;
    }

    public String getCarName() {
        return carName;
    }

    public int getMoveCnt() {
        return moveCnt;
    }
}
