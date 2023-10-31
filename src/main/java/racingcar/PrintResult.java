package racingcar;

import java.util.List;

public class PrintResult {
    public void  PrintOneAttemptResult(List<Integer> advancementResult, List<String> carName){
        for(int carIndex=0; carIndex<carName.size();carIndex++){
            System.out.print(carName.get(carIndex) + " : ");
            for(int num=0; num<advancementResult.get(carIndex);num++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void PrintWinnerCarName(List<Integer> winnerIndex, List<String> carName){

    }
}
