package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;

public class UserInputReceiver {
    public static String messageToUser(String message) {
        System.out.println(message);
        return Console.readLine();
    }
}
