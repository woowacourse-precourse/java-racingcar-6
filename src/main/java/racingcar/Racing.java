package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Racing {
    private int recentRound;
    private ArrayList<Integer> playerResult = new ArrayList<>();
    Input input = new Input();
    public void startRacing(){
        setPlayerResult();
        movePlayer(verifyNumber());
    }
    public int selectNumber(){
        int pickNumber=Randoms.pickNumberInRange(0,9);
        return pickNumber;
    }
    public boolean verifyNumber(){
        if (selectNumber()>=4){
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
    public void movePlayer(boolean move){
        for (int i = 0; i < playerResult.size(); i++) {
            if(move){
                playerResult.set(i,playerResult.get(i)+1);
            }
        }
    }


}
