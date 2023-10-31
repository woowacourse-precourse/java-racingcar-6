package racingcar.v4;

import camp.nextstep.edu.missionutils.Console;

public class RacingGame {
    public String inputTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String inputTryCount = Console.readLine();
        return inputTryCount;
    }


}
