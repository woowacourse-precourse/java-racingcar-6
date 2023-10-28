package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    private List<String> carsNameList = new ArrayList<>();

    public void setCarsNameList(List<String> input) {
        carsNameList = input;
    }
    public void singleAttemptResult(List<Integer> carsPositionList) {
        for(int i = 0; i < carsPositionList.size(); i++) {
            System.out.println(carsNameList.get(i) + " : " + "-".repeat(carsPositionList.get(i)));
        }
        System.out.print("\n");
    }
}
