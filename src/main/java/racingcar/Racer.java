package racingcar;

public class Racer {
    private final String name;
    private final Car raceCar;
    private Integer currentPos;
    Racer(String racerName){
        raceCar = CarFactory.getNewCarInstance();
        name = racerName;
        currentPos = 0;
    }
    public void continueRace(){
        Boolean canMoveForwardStatus = raceCar.checkCanMoveForwardIfSpeedIsExceedThreshold();
        if (canMoveForwardStatus){
            currentPos+=1;
        }
    }
    public Integer getCurrentPos(){
        return currentPos;
    }
    public Car getRaceCar(){return raceCar;};
}
