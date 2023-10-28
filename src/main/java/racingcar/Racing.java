package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Racing {
    private int recentRound;
    private ArrayList<Integer> playerResult = new ArrayList<>();
    Input input;
    public Racing(Input input){
        this.input = input;
    }

    //랜덤으로 뽑은 숫자를 검증하여 움직이는 코드
    public void startRacing(int playerNumber){
        movePlayer(verifyNumber(selectNumber()),playerNumber);
    }
    public int selectNumber(){
        int pickNumber=Randoms.pickNumberInRange(0,9);
        return pickNumber;
    }
    public boolean verifyNumber(int pickNumber){
        if (pickNumber>=4){
            return true;
        }
        return false;
    }
    public void setPlayerResult(){
        for (int i = 0; i < input.getPlayerName().size(); i++) {
            playerResult.add(0);
        }
    }
    public ArrayList<Integer> getPlayerResult(){
        return playerResult;
    }
    public void movePlayer(boolean move,int playerNumber){
        if(move){
            playerResult.set(playerNumber,playerResult.get(playerNumber)+1);
        }
    }


}
