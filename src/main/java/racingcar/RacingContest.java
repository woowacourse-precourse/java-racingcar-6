package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingContest {
    List<RacingCar> racingCars;
    private final int round;

    RacingContest(int round){
        this.racingCars = new ArrayList<>();
        this.round = round;
    }

    void insertCar(RacingCar newCar){
        //이미 중복된 이름을 가지고 있을 경우 Exception
        for(RacingCar existCar : racingCars){
            if(existCar.getName().compareTo(newCar.getName())==0){
                throw new IllegalArgumentException();
            }
        }

        racingCars.add(newCar);
    }

    void playGame(){
        for(int round =0; round < this.round; round++){
            for(RacingCar racingCar : racingCars){
                racingCar.playRound();
                System.out.println(racingCar.progressStatus());
            }
            System.out.println();
        }
    }

    ArrayList<String> returnWinner(){
        ArrayList<String> winners = new ArrayList<>();
        int max;

        Collections.sort(racingCars);
        max = racingCars.get(0).getAdvanceCount();

        for(RacingCar playerCar : racingCars){
            if(playerCar.getAdvanceCount()<max){
                break;
            }

            winners.add(playerCar.getName());
        }
        return winners;
    }
}
