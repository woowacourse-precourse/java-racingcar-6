package racingcar.view;

import java.util.List;
import java.util.Map;

import static racingcar.util.OutputMessage.*;
import static racingcar.util.Constants.HYPHEN;
import static racingcar.util.Constants.SQUARE_BRACKET_ELIMINATE;
import static racingcar.util.Constants.EMPTY;
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
    public void moveResult(Map<String,Integer> carMap, List<String> carList) {
        for (String car : carList) {
            System.out.print(car + " : ");
            for(int i=0;i<carMap.get(car);i++){
                System.out.print(HYPHEN);
            }
            System.out.println();
        }
        System.out.println();
    }
    public void winnerList(List<String> winnerList){
        String str = winnerList.toString().replaceAll(SQUARE_BRACKET_ELIMINATE, EMPTY);
        System.out.println(str);
    }
}
