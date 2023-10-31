package racingcar.racer;

import racingcar.car.Car;
import racingcar.car.CarFactory;
import racingcar.configs.Config;

public class Racer {
    private final String name;
    private final Car raceCar;
    private int currentPos;
    public Racer(String racerName){
        raceCar = CarFactory.getNewCarInstance();
        name = racerName;
        currentPos = 0;
    }
    public void runRaceEachStep(){
        if (canMoveForward()){
            currentPos+= Config.FORWARD_DISTANCE;
        }
    }
    private boolean canMoveForward(){
        return raceCar.checkCarSpeedIsExceedThreshold();
    }
    public int getCurrentPos(){
        return currentPos;
    }
    public boolean isCarInitialized(){return raceCar!=null;};
    public String getName(){return name;}
}
