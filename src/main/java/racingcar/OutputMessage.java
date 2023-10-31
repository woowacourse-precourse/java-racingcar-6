package racingcar;

import java.util.ArrayList;
import java.util.List;

public class OutputMessage {
    private List<String> carNames;
    private List<Integer> maxIndexs;

    private static final int MIN_WINNER = 1;

    public OutputMessage(List<Integer> maxIndexs, List<String> carNames){
        this.maxIndexs = maxIndexs;
        this.carNames = carNames;
    }

    public void winnerPrint(){
        if(maxIndexs.size() > MIN_WINNER){
            List<String> winners = new ArrayList<>();
            for(int index : maxIndexs){
                winners.add(carNames.get(index));
            }
            String result = "최종 우승자 : "+ String.join(", ", winners);
            System.out.println(result);
        }

        if(maxIndexs.size() == MIN_WINNER){
            int index = maxIndexs.get(0);
            String result = "최종 우승자 : "+ carNames.get(index);
            System.out.println(result);
        }
    }

    public static void racePrint(List<String> raceSituation){
        for(String result : raceSituation){
            System.out.println(result);
        }
    }
}