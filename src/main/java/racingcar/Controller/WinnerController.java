package racingcar.Controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class WinnerController {
    static MoveRandomNumber moveRandomNumber = new MoveRandomNumber();
    static OutputView outputView = new OutputView();


    public static Map<String,Integer> judgeWin(){
        InputView.printAskCarName();
        List<Map<String,Integer>> carDataMapList =  moveRandomNumber.generateRandomGameNumber();
        Map<String,Integer> carPosition = new HashMap<>();

        moveCarPoint( carDataMapList, carPosition);


        System.out.println(carPosition);
        RacingResult.printRacingResult(carPosition);


        return carPosition;
    }






    public static void moveCarPoint(List<Map<String,Integer>> carDataMapList, Map<String,Integer> carPosition) {
        for (Map<String,Integer> racerCarName :carDataMapList){
            for( String Key : racerCarName.keySet()){
                int Move;
                if(racerCarName.get(Key) >= 4){
                    Move = 1;
                }else {
                    Move = 0;
                }

                int currentPosition = carPosition.getOrDefault(Key, 0);
                carPosition.put(Key, currentPosition + Move);
            }

        }

    }


}