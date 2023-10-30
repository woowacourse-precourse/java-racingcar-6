package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class GameStarter {
    public static Integer gameNumber(){
        System.out.println("시도할 회수는 몇회인가요?");
        int gameNum = Integer.parseInt(Console.readLine());
        return gameNum;
    }
}
