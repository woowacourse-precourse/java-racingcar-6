package Model;

import camp.nextstep.edu.missionutils.Randoms;
import Config.GameConfig;

public class RacingCar implements Comparable<RacingCar>{
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

    public String visibleDistance(){
        return "-".repeat(this.distance);
    }

    public boolean isSameDistance(RacingCar other){
        return other.distance == this.distance;
    }

    @Override
    public int compareTo(RacingCar other) {
        return this.distance - other.distance;
    }
}
