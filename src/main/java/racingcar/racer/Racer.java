package racingcar.racer;

import racingcar.car.Car;
import racingcar.car.CarFactory;
import racingcar.configs.Config;

public class Racer {
    private final String name;
    private final Car raceCar;
    private Integer currentPos;
    public Racer(String racerName){
        raceCar = CarFactory.getNewCarInstance();
        name = racerName;
        currentPos = 0;
    }
    public void runRaceEachStep(){
        Boolean canMoveForwardStatus = raceCar.checkCanMoveForwardIfSpeedIsExceedThreshold();
        if (canMoveForwardStatus){
            currentPos+= Config.FORWARD_DISTANCE;
        }
    }
    public Integer getCurrentPos(){
        return currentPos;
    }
    public Car getRaceCar(){return raceCar;};
    public String getName(){return name;}
}
