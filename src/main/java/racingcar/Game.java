package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    User user;
    String[] carName;
    List<Integer> computer = new ArrayList<>();
    public Game(User user){
        this.user = user;
    }

    public void gameStart(){
        carName = user.getCarName();
        int tryNum =user.getTryNum();
        runGame(carName.length, tryNum);
    }
    public void runGame(int carSize, int tryNum){
        int[] goCount = new int[carSize];
        for(int i=0; i<tryNum; i++){
        }

    }

    private void setRandomCount(int[] goCount) {

    }
}
