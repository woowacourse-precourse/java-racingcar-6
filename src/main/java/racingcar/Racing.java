package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Racing
{
    private final int racingCount;
    public Racing(int racingCount) {
        this.racingCount = racingCount;
    }
    public void Race(Racer racer){
        ArrayList<Integer> RacerList = new ArrayList<>();
        for(int i=0;i<this.racingCount;i++){
            for(int j=0;j<racer.name.length;j++) {
                RacerList.add(Randoms.pickNumberInRange(1, 9));
            }
            RacingResult(RacerList,racer);
            System.out.println(racer.toString());
            RacerList.clear();
        }
    }
    private static void RacingResult(ArrayList<Integer>RacerRanking,Racer racer){
        ArrayList<Integer> CounterList = new ArrayList<>();
        System.out.println(racer.toString());
        for (Integer integer : RacerRanking) {
            if (integer >= 4) {
                racer.advance();
            }
        }
    }

}
