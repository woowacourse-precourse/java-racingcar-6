package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import racingcar.firstClassCollection.RoundTryCount;

public class GameManager {
   private RoundTryCount roundTryCount;
    public void receiveRoundTryCount(){
        int roundTryCount = Integer.parseInt(Console.readLine());
        this.roundTryCount=new RoundTryCount(roundTryCount);
    }

    public void proceedRound(){
    }

    public void printWinner(){
        
    }
}
