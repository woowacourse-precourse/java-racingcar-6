package racingcar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Racing racing = new Racing();
        UserInput userInput = new UserInput();
        List<String> racingCarName = userInput.inputRacingCarName();
        int attemptNumber = userInput.inputAttemptNumber();
        //전진한 결과를 담을 리스트
        List<Integer> advancementResult = racing.Start(attemptNumber, racingCarName.size());
        int maxAdvancement = Collections.max(advancementResult);
        List<Integer> winnerIndex = new ArrayList<>();
        for(int i=0; i<advancementResult.size(); i++){
            if (advancementResult.get(i)==maxAdvancement){
                winnerIndex.add(i);
            }
        }
        System.out.println(winnerIndex);
    }
}
