package racingcar.model;

public class CarDto {
    private String carName;
    private int advancementCount;

    public CarDto(String carName, int advancementCount){
        this.carName = carName;
        this.advancementCount = advancementCount;
    }

    public String getCarName(){
        return carName;
    }

    public int getAdvancementCount(){
        return advancementCount;
    }
}
