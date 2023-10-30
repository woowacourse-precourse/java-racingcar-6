package racingcar.Controller;

import static racingcar.Controller.WinnerController.outputView;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.View.InputView;

public class MoveRandomNumber {


    public static List<Map<String,Integer>> generateRandomGameNumber() {
        List< Map<String,Integer>> randomNumbersMap = new ArrayList<>();    // 맵을 저장할 리스트
        Map<String,Integer> carCountMap = InputView. storeCarName();

        int tryCountNumber = InputView.askTryCount();
        outputView.printResultMsg();

        for( int i = 0 ; i < tryCountNumber; i++ ){
            for(String key : carCountMap.keySet()){
                Map<String, Integer> carCountMapNumber = new HashMap<>();
                int randomNumber =  Randoms.pickNumberInRange(0, 9);
                carCountMapNumber.put(key,randomNumber);
                randomNumbersMap.add(carCountMapNumber);
                String randomNumberBar = outputView.printRandomCount(randomNumber);
                System.out.print(carCountMapNumber.keySet() + " : " + randomNumberBar);

                System.out.println();

            }
            System.out.println();
        }


        return randomNumbersMap;
    }





}
