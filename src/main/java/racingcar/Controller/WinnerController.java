package racingcar.Controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class WinnerController {
    static MoveRandomNumber moveRandomNumber = new MoveRandomNumber();
    static OutputView outputView = new OutputView();


    public static Map<String,Integer> judgeWin(){
        //carPosition = InputView.storeCarName();
        List<Map<String,Integer>> carDataMapList =  moveRandomNumber.generateRandomGameNumber();
        Map<String,Integer> carPosition = new HashMap<>();

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
        System.out.println(carPosition);
        RacingResult.printRacingResult(carPosition);


        return carPosition;
    }






//    public static void printRunMsg() {
//
//        boolean allValuesAreZero = judgeWin().values().stream().allMatch(value -> value == 0);
//        if (allValuesAreZero) {
//            throw new IllegalArgumentException("All values in the Map are 0.");
//        }else {
//            int maxValue = Integer.MIN_VALUE;
//
//            // 최대 값을 가지고 있는 key 초기화
//            String maxKeys = "";
//
//            // Map을 순회하며 최대 값을 찾음
//            for (Entry<String, Integer> entry : judgeWin().entrySet()) {
//                int value = entry.getValue();
//
//                if (value > maxValue) {
//                    maxValue = value;
//                    maxKeys = entry.getKey();
//                } else if (value == maxValue) {
//                    maxKeys += ", " + entry.getKey();
//                }
//            }
//            outputView.printWinnerName();
//            System.out.println(maxKeys);
//        }
//
//    }

}