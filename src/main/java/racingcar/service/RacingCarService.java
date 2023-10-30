package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.RacingCar;

public class RacingCarService {
    public void save(String[] carNames){
        List<RacingCar> racingCars = new ArrayList<>();

        for(int i = 0; i < carNames.length; i++){
            racingCars.add(new RacingCar(carNames[i]));
        }
    }

    public void moveRandomly(){

    }

    public void getWinner(){

    }

    private int getMaxMoveNumber(List<RacingCar> racingCars){
        int max = 0;

        for(RacingCar racingCar : racingCars){
            int moveNumber = racingCar.getMoveNumber();
            if(isBiggerThanMax(max, moveNumber){
                max = moveNumber;
            }
        }

        return max;
    }

    private boolean isBiggerThanMax(int max, int number){
        return max < number;
    }
}
