package racingcar.view;

import java.util.LinkedHashMap;
import java.util.List;
import racingcar.RacingList;

public class OutputView {

    public void printState(RacingList racingList) {
        LinkedHashMap<String, Integer> carList = racingList.getCarList();
        for (String str : carList.keySet()) {
            System.out.println(str + " : " + "-".repeat(carList.get(str)));
        }
        System.out.println();
    }
    
    public void printResult(List<String> result) {
        String winners = String.join(", ", result);
        System.out.println("최종 우승자 : " + winners);
    }
}
