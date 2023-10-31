package racingcar.play.user;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Convert;

public class User {
    public static int input(){
        System.out.println("시도할 회수는 몇회인가요?");
        String s = Console.readLine();

        return Convert.stringToInteger(s);

    }
}
