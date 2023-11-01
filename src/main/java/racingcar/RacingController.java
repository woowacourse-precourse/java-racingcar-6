package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class RacingController {
    int rounds;
    List<Car> racingCars;

    protected RacingController(int rounds, List<Car> racingCars){
        this.rounds = rounds;
        this.racingCars = racingCars;
        this.proceedRound();
    }
    private void proceedRound(){
        System.out.println("\n실행 결과");
        for (int i=0; i<this.rounds; i++){
            randomlyGoForward(this.racingCars);
            printRoundResult();
        }
        endRacing();
    }
    private void printRoundResult(){
        for (Car car : this.racingCars){
            System.out.println(car.toString());
        }
        System.out.println();
    }
    private void endRacing(){
        List<String> winnerRacers = new ArrayList<>();
        int maxRacingProgress = 0;

        for (Car car : this.racingCars){
            int racingProgress = car.getRacingProgress();
            if (racingProgress > maxRacingProgress){
                maxRacingProgress = racingProgress;
                winnerRacers.clear();
                winnerRacers.add(car.getRacerName());
            }else if (car.getRacingProgress() == maxRacingProgress){
                winnerRacers.add(car.getRacerName());
            }
        }

        System.out.print("최종 우승자 : ");
        for (int i=0; i<winnerRacers.size(); i++){
            System.out.print(winnerRacers.get(i));
            if (i != winnerRacers.size()-1) System.out.print(", ");
        }
    }

    private void randomlyGoForward(List<Car> cars){
        for (Car car : cars){
            if (Randoms.pickNumberInRange(0,9) >= 4) car.incrementRacingProgress();
        }
    }
}
