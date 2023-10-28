package racingcar.view;

import java.util.LinkedHashMap;
import java.util.List;
import racingcar.RacingList;

public class OutputView {
    public static final String RUNNING_RSEULT = "실행결과";
    public static final String FINAL_WINNDERS = "최종 우승자 : ";


    public void printState(RacingList racingList) {
        System.out.println(RUNNING_RSEULT);
        LinkedHashMap<String, Integer> carList = racingList.getCarList();
        for (String str : carList.keySet()) {
            System.out.println(str + " : " + "-".repeat(carList.get(str)));
        }
        System.out.println();
    }

    public void printResult(List<String> result) {
        String winners = String.join(", ", result);
        System.out.println(FINAL_WINNDERS + winners);
    }
}
