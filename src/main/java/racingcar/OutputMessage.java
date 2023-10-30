package racingcar;

import java.util.ArrayList;
import java.util.List;

public class OutputMessage {
    private List<String> carNames;
    private List<Integer> maxindexs;

    private static final int MIN_WINNER = 1;

    public OutputMessage(List<Integer> maxindexs, List<String> carNames){
        this.maxindexs = maxindexs;
        this.carNames = carNames;
    }

    public void winnerPrint(){
        if(maxindexs.size() > MIN_WINNER){
            List<String> winners = new ArrayList<>();
            for(int index : maxindexs){
                winners.add(carNames.get(index));
            }
            String result = "최종 우승자 : "+ String.join(", ", winners);
            System.out.println(result);
        }

        if(maxindexs.size() == MIN_WINNER){
            int index = maxindexs.get(0);
            String result = "최종 우승자 : "+ carNames.get(index);
            System.out.println(result);
        }
    }
}