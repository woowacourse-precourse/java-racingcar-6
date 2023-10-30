package racingcar;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Score {
    public List<Integer> score;
    public Score(int playerNum){
        score = new ArrayList<>(playerNum);
        for(int i = 0;i<playerNum;i++){
            score.add(0);
        }
    }

    public boolean randNum(){
        if(Randoms.pickNumberInRange(0,9)>=4){
            return true;
        }
        return false;
    }

    public void countScore(boolean win, int memberNum){
        if(win) {
            score.set(memberNum, score.get(memberNum)+1);
        }
    }

    public void printResult(){
        for (int i : score){
            System.out.println(i);
        }

    }
}
