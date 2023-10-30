package racingcar.view;

import java.util.Map;

import static racingcar.util.OutputMessage.*;
import static racingcar.util.Constants.HYPHEN;
public class OutputView {
    public void start() {
        System.out.println(START);
    }
    public void moveSize() {
        System.out.println(MOVE_SIZE);
    }
    public void result() {
        System.out.println(RESULT);
    }
    public void winner() {
        System.out.print(WINNER);
    }
    public void moveResult(Map<String,Integer> carMap) {
        for (String car : carMap.keySet()) {
            System.out.print(car + " : ");
            for(int i=0;i<carMap.get(car);i++){
                System.out.print(HYPHEN);
            }
            System.out.println();
        }
        System.out.println();
    }
}
