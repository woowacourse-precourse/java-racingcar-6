package racingcar.domain;

import java.util.List;

public class Result {
    public void racePrint(List<Integer> raceCars, List<Integer> raceMove){
        for(int i = 0; i < raceCars.size(); i++){
            System.out.print(raceCars.get(i)+" :");
            for(int j = 0; j < raceMove.get(i); j++){
                System.out.print(" -");
            }
            System.out.println(" ");
        }
    }
}
