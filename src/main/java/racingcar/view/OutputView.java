package racingcar.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static racingcar.consts.ConstString.DASH;
import static racingcar.consts.ConstString.COLON;
import static racingcar.consts.ConstString.WINNER_MESSAGE;

public class OutputView {
    private void printPosition(int move){
        for(int i = 0; i < move; i++){
            System.out.print(DASH);
        }
        System.out.println();
    }

    public void printAllMove(HashMap<String,Integer> carList){
        for(Map.Entry<String, Integer> item : carList.entrySet()){
            System.out.print(item.getKey() + COLON);
            printPosition(item.getValue());
        }
        System.out.println();
    }

    public void printWinner(List<String> winnerList){
        System.out.print(WINNER_MESSAGE);
        System.out.print(winnerList.get(0));
        if(winnerList.size() > 1){
            for(int i = 1; i < winnerList.size(); i++){
                System.out.print(", " + winnerList.get(i));
            }
        }
    }
}
