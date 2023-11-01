package racingcar.view;
import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    public static String getUserInputForCarNames() {
        String str = Console.readLine();
        System.out.println(str);
        return str;
    }
    public static String getUserInputForGameRound() {
        String str = Console.readLine();
        System.out.println(str);
        return str;
    }
}

