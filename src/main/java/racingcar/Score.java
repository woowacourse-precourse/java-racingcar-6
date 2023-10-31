package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Score {
    public List<Integer> score;
    private int max;

    public Score(int playerNum){
        max = 0;
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

    public void printResult(int memberNum){
        for (int i=0;i<score.get(memberNum);i++){
            System.out.print("-");
        }
    }

    public List<String> printWinner(Player member){
        max = Collections.max(score);
        List<String> winner = new ArrayList<>(member.getSize());
        for(int i=0;i<score.size();i++){
            getMember(score.get(i), max, member, winner, i);
        }
        return winner;
    }

    public void getMember(int num, int max, Player member, List<String> winner, int index){
        if(num==max){
            winner.add(member.getName(index));
        }
    }
}
