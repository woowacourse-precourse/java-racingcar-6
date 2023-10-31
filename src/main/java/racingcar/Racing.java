package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

public class Racing {
    public int[] startOneRound(int[] locations){
        for(int i = 0; i < locations.length; i++){
            if(goOrStop()) locations[i]++;
        }
        return locations;
    }

    private boolean goOrStop(){
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if(randomNumber >= 4) return true;
        else return false;
    }
}
