package user;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    public static List<String> playerInput() {
        String players = Console.readLine();

        List<String> playersArray = new ArrayList<>(Arrays.asList(players.split(",")));
        ExceptionHandler.raiseException(playersArray);

        return playersArray;
    }
}

