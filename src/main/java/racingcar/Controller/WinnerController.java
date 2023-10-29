package racingcar.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class WinnerController {
    static MoveRandomNumber moveRandomNumber = new MoveRandomNumber();
    OutputView outputView = new OutputView();

    public static int Move;
    public static Map<String,Integer> judgeWin(){
        Map<String,Integer> carPosition = new HashMap<String, Integer>();
        carPosition = InputView.storeCarName();
        for (Map<String,Integer> racerCarName : moveRandomNumber.generateRandomGameNumber()){
            for( String Key : racerCarName.keySet()){
                if(racerCarName.get(Key) >= 4){
                    Move = 1;
                }else {
                    Move = 0;
                }
                if (carPosition.containsValue(0)){
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

        boolean allValuesAreZero = judgeWin().values().stream().allMatch(value -> value == 0);
        if (allValuesAreZero) {
            throw new IllegalArgumentException("All values in the Map are 0.");
        }else {
            int maxValue = Integer.MIN_VALUE;

            // 최대 값을 가지고 있는 key 초기화
            String maxKeys = "";

            // Map을 순회하며 최대 값을 찾음
            for (Entry<String, Integer> entry : judgeWin().entrySet()) {
                int value = entry.getValue();

                if (value > maxValue) {
                    maxValue = value;
                    maxKeys = entry.getKey();
                } else if (value == maxValue) {
                    maxKeys += ", " + entry.getKey();
                }
            }
        }



    }

}