package racingcar.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.View.InputView;

public class MoveRandomNumber {
    static InputView inputView = new InputView();

    public static List<Map<String,Integer>> generateRandomGameNumber() {
        List< Map<String,Integer>> randomNumbersMap = new ArrayList<>();    // 맵을 저장할 리스트
        Map<String,Integer> carCountMap = inputView.storeCarName();

        for( int i = 0 ; i < inputView.askTryCount(); i++ ){
            for(String key : carCountMap.keySet()){
                carCountMap.put(key, Randoms.pickNumberInRange(0, 9));
                randomNumbersMap.add(carCountMap);
            }
        }

        return randomNumbersMap;
    }



}
