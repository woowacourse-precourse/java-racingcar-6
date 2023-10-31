package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Racing racing = new Racing();
        UserInput userInput = new UserInput();
        List<Integer> winnerIndex = new ArrayList<>();
        PrintResult printer = new PrintResult();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> racingCarName = userInput.inputRacingCarName();
        System.out.println("시도할 회수는 몇회인가요?");
        int attemptNumber = userInput.inputAttemptNumber();

        //전진한 결과를 담을 리스트
        List<Integer> advancementResult = racing.Start(attemptNumber, racingCarName);

        int maxAdvancement = Collections.max(advancementResult);
        for(int i=0; i<advancementResult.size(); i++){
            if (advancementResult.get(i)==maxAdvancement){
                winnerIndex.add(i);
            }
        }

        printer.PrintWinnerCarName(winnerIndex, racingCarName);
    }
}
