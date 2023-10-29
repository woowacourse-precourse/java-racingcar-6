package racingcar.Controller;

import java.util.HashMap;
import java.util.Map;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class WinnerController {
    MoveRandomNumber moveRandomNumber = new MoveRandomNumber();
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    public int Move;
    public Map<String,Integer> judgeWin(){
        Map<String,Integer> carPosition = new HashMap<String, Integer>();
        for (Map<String,Integer> racerCarName : moveRandomNumber.generateRandomGameNumber()){
            for( String Key : racerCarName.keySet()){
                if(racerCarName.get(Key) >= 4){
                    Move = 1;
                }else {
                    Move = 0;
                }
                if (carPosition.isEmpty()){
                    carPosition.put(Key, Move);
                }else {
                    int position = carPosition.get(Key) + Move;
                    carPosition.put(Key,position);
                }
            }

        }
        return carPosition;
    }

    //실행결과 출력
    public void printRunMsg() {
        for (Map<String,Integer> racerCarName : moveRandomNumber.generateRandomGameNumber()){
            for( String Key : racerCarName.keySet()){
                int value = racerCarName.get(Key);
                System.out.print(Key + " : " );
                outputView.printRandomCount(value);
            }
        }

    }

}