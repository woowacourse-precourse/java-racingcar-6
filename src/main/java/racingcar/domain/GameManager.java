package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import racingcar.IoManager;
import racingcar.firstClassCollection.RoundTryCount;

import java.util.List;

public class GameManager {
   private RoundTryCount roundTryCount;
   private List<Car> cars;
   public void gameStart(){

   }
    public void receiveRoundTryCount(){
        IoManager.printEnterRoundTryCount();
        int roundTryCount = Integer.parseInt(Console.readLine());
        this.roundTryCount=new RoundTryCount(roundTryCount);
    }

    public void proceedRound(){
        IoManager.printResultMessage();
        while(roundTryCount.isRemainRound()){
            roundTryCount.consumeRound();
            for(Car car:cars){
                car.proceedOwnRound();
                IoManager.println(car.getFormattedPostion());
            }
            IoManager.printEmptyLine();
        }

    }

    public void printWinner(){
        
    }
}
