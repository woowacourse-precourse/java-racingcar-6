package racingcar.View;
import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

import java.util.Arrays;

public class GameView {
    public String inputCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }
    public int inputTrialGame(){
        System.out.println("시도할 회수는 몇회인가요?");
        String trialNumStr = Console.readLine();
        int trialNum = Integer.parseInt(trialNumStr);
        return trialNum;
    }

    public void printResultHead(){
        System.out.println();
        System.out.println("실행결과");
    }

}
