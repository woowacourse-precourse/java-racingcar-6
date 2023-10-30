package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.util.NumberGenerator;

public class RacingCarService {
    public List<RacingCar> save(String[] carNames){
        List<RacingCar> racingCars = new ArrayList<>();

        for(int i = 0; i < carNames.length; i++){
            racingCars.add(new RacingCar(carNames[i]));
        }

        return racingCars;
    }

    public void moveRandomly(List<RacingCar> racingCars){
        for(RacingCar racingCar : racingCars){
            int randomNumber = NumberGenerator.generateNumber();

            if(randomNumber > 4){
                racingCar.increaseMoveNumber();
            }
        }
    }

    public List<RacingCar> getWinner(List<RacingCar> racingCars){
        int maxMoveNumber = getMaxMoveNumber(racingCars);

        List<RacingCar> winners = new ArrayList<>();

        for(RacingCar racingCar : racingCars){
            int moveNumber = racingCar.getMoveNumber();

            if(isEqualsMax(maxMoveNumber, moveNumber)){
                winners.add(racingCar);
            }
        }

        return winners;
    }

    private int getMaxMoveNumber(List<RacingCar> racingCars){
        int max = 0;

        for(RacingCar racingCar : racingCars){
            int moveNumber = racingCar.getMoveNumber();

            if(isBiggerThanMax(max, moveNumber)){
                max = moveNumber;
            }
        }

        return max;
    }

    private boolean isEqualsMax(int max, int number){
        return max == number;
    }

    private boolean isBiggerThanMax(int max, int number){
        return max < number;
    }
}
