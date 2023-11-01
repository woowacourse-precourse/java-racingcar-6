package racingcar;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Validators {
    public static void isCarNameOverFive(String playerName) {
        if (playerName.length() > 5) {
            System.out.println("잘못된 값을 입력하였습니다.");
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
    }

    public static void isListElementOverFive(ArrayList<String> playerList) {
        for (String player : playerList) {
            isCarNameOverFive(player);
        }
    }

    public static void isInteger(String inputString) {
        Pattern pattern = Pattern.compile("^\\d+$");
        boolean result = pattern.matcher(inputString).matches();

        if (!result) {
            System.out.println("잘못된 값을 입력하였습니다.");
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
    }
}



