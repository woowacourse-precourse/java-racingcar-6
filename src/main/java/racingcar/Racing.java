package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Racing {
    private int recentRound;
    private ArrayList<Integer> playerResult = new ArrayList<>();
    Input input = new Input();
    public void startRacing(){
        setPlayerResult();
        for (int i = 0; i < input.getRound(); i++) {
            movePlayer(verifyNumber(selectNumber()),i);
        }

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
