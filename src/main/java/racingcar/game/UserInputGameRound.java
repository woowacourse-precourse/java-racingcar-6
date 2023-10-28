package racingcar.game;

import camp.nextstep.edu.missionutils.Console;

public class UserInputGameRound {
    private static String inputGameRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }
}
