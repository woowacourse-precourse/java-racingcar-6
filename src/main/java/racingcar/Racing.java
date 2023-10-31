package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

public class Racing {
    public int[] startRacing(int length, int[] locations){
        for(int i = 0; i < length; i++){
            startOneRound(locations);
        }
        return locations;
    }

    private int[] startOneRound(int[] locations){
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
