package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;

public class Judgement {
    public void whoisWinner(ArrayList<String> cars, ArrayList<Integer> progress){
        int maxPoint = 0;
        for(int i=0; i<cars.size(); i++){
            maxPoint = Math.max(maxPoint, progress.get(i));
        }
        ArrayList<String> winners = new ArrayList<>(Arrays.asList());

        for(int i=0; i<progress.size(); i++){
            if(progress.get(i) == maxPoint){
                winners.add(cars.get(i));
            }
        }
        String result = String.join(", ", winners);
        System.out.println("최종 우승자 : " + result);
    }
}
