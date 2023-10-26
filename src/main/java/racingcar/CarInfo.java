package racingcar;

public class CarInfo {
    private final String carName;
    private int totalMovement;

    public CarInfo(String carName, int totalMovement){
        this.carName = carName;
        this.totalMovement = totalMovement;
    }

    public String getCarName(){
        return this.carName;
    }

    public int getTotalMovement(){
        return this.totalMovement;
    }

    public void updateTotalMovement(int movement){
        this.totalMovement += movement;
    }
}
