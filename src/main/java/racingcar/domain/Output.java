package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Output {
    // 전진 횟수를 변경하기 위한 메서드
    public List<Integer> gameStart(List<Boolean> morethan4, List<Integer> fowardCount){
        for(int i = 0; i < morethan4.size(); i++){
            if(morethan4.get(i)){
                fowardCount.set(i, fowardCount.get(i) + 1);
            }
        }
        return fowardCount;
    }

    // 게임 진행에 따라 전진횟수를 출력하는 메서드
    public void log(List<String> car, List<Integer> fowardCount){
        for(int i = 0; i < car.size(); i++){
            System.out.println(car.get(i) + " : " + "-".repeat(fowardCount.get(i)));
        }
        System.out.println();
    }

    // 우승자들을 찾는 메소드
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
