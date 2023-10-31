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
        //전진한 결과를 담을 리스트
        List<Integer> advancement = new ArrayList<>();
        int attemptNumber = userInput.inputAttemptNumber();
        for(int i=0; i<racingCarName.size();i++){
            advancement.add(racing.Race(attemptNumber));
        }
        int maxAdvancement = Collections.max(advancement);
        List<Integer> winnerIndex = new ArrayList<>();
        for(int i=0; i<advancement.size(); i++){
            if (advancement.get(i)==maxAdvancement){
                winnerIndex.add(i);
            }
        }
        System.out.println(advancement);
        System.out.println(winnerIndex);
    }
}
