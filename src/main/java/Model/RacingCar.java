package Model;

import camp.nextstep.edu.missionutils.Randoms;
import Config.GameConfig;

public class RacingCar {
    private final String name;
    private int distance;

    public RacingCar(String name){
        this.name = name;
        this.distance = 0;
    }

    public String getName(){
        return this.name;
    }

    public void forward(){
        int generatedValue = Randoms.pickNumberInRange(GameConfig.minValue, GameConfig.maxValue);
        if (generatedValue >= GameConfig.movingCondition){
            this.distance += 1;
        }
    }
}
