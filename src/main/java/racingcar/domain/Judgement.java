package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;

public class Judgement {
    public void whoisWinner(String[] cars, Integer[] progress){
        int maxPoint = 0;
        for(int i=0; i<cars.length; i++){
            maxPoint = Math.max(maxPoint, progress[i]);
        }
        ArrayList<String> winners = new ArrayList<>(Arrays.asList());

        for(int i=0; i<progress.length; i++){
            if(progress[i] == maxPoint){
                winners.add(cars[i]);
            }
        }
        String result = String.join(", ", winners);
        System.out.println("최종 우승자 : " + result);
    }
}
