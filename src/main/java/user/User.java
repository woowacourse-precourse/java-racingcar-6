package user;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class User {
    public static List<String> input() {
        String players = Console.readLine();
        return new ArrayList<>(Arrays.asList(players.split(",")));
    }
}

