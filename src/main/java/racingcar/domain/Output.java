package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Output {
    public List<Integer> gameStart(List<Integer> computer, List<Boolean> morethan4, List<Integer> fowardCount){
        for(int i = 0; i < morethan4.size(); i++){
            if(morethan4.get(i)){
                fowardCount.set(i, fowardCount.get(i) + 1);
            }
        }

        return fowardCount;
    }

    public void log(List<String> car, List<Integer> fowardCount){
        for(int i = 0; i < car.size(); i++){
            System.out.println(car.get(i) + " : " + "-".repeat(fowardCount.get(i)));
        }
        System.out.println();
    }


    public List<String> winner(List<String> car, List<Integer> fowardCount){
        List<String> winnerName = new ArrayList<>();
        int max = Collections.max(fowardCount);

        for(int i = 0; i < fowardCount.size(); i++){
            if(fowardCount.get(i) == max){
                winnerName.add(car.get(i));
            }
        }

        return winnerName;
    }
}
