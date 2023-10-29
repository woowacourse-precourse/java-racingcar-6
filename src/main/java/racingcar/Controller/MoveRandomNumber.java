package racingcar.Controller;

import static racingcar.Controller.WinnerController.outputView;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.View.InputView;

public class MoveRandomNumber {
    //static InputView inputView = new InputView();

    public static List<Map<String,Integer>> generateRandomGameNumber() {
        List< Map<String,Integer>> randomNumbersMap = new ArrayList<>();    // 맵을 저장할 리스트
        Map<String,Integer> carCountMap = InputView. storeCarName();

        int tryCountNumber = InputView.askTryCount();

        for( int i = 0 ; i < tryCountNumber; i++ ){
            for(String key : carCountMap.keySet()){
                Map<String, Integer> carCountMapNumber = new HashMap<>();
                int randomNumber =  Randoms.pickNumberInRange(0, 9);
                carCountMapNumber.put(key,randomNumber);
                randomNumbersMap.add(carCountMapNumber);
                System.out.print(carCountMapNumber.keySet() + " : " );
                outputView.printRandomCount(randomNumber);

            }
            System.out.println();
        }


        return randomNumbersMap;
    }





}
