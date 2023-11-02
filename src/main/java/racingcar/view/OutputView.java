package racingcar.view;

import java.util.List;
import java.util.Map;

import static racingcar.util.OutputMessage.*;
import static racingcar.util.Constants.HYPHEN;
import static racingcar.util.Constants.DELIMITER;
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
    public StringBuilder moveResult(Map<String,Integer> carMap, List<String> carList,StringBuilder sb) {
        for (String car : carList) {
            sb.append(car).append(" : ");
            for (int i = 0; i < carMap.get(car); i++) {
                sb.append(HYPHEN);
            }
            sb.append("\n");
        }
        return sb;
    }
    public StringBuilder winnerList(List<String> winnerList, StringBuilder sb){
        sb.append(String.join(DELIMITER,winnerList));
        return sb;
    }
    public void printBuilder(StringBuilder sb) {
        System.out.println(sb);
    }
}
