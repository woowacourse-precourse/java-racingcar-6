package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class GameStarter {
    public static String gameNumber(){
        System.out.println("시도할 회수는 몇회인가요?");
        String gameNum = Console.readLine();
        return gameNum;
    }
}
