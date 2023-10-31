package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Racing {
    private int GoOrStop(){
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber>=4){
            return 1;
        }
        return 0;
    }
    public int Race(int attemptNumber){
        int advance = 0;
        for(int i=0; i<attemptNumber; i++){
            advance += GoOrStop();
        }
        return advance;
    }
}
