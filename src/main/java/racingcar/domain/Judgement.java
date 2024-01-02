package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;

public class Judgement {
    public String judgeWinner(ArrayList<Car> carList){
        int maxPoint = 0;
        for(int i=0; i<carList.size(); i++){
            maxPoint = Math.max(maxPoint, carList.get(i).getProgress());
        }
        ArrayList<String> winners = new ArrayList<>(Arrays.asList());
        for(int i=0; i<carList.size(); i++){
            if(carList.get(i).getProgress() == maxPoint){
                winners.add(carList.get(i).getName());
            }
        }
        String result = String.join(", ", winners);

        return result;
    }
}
