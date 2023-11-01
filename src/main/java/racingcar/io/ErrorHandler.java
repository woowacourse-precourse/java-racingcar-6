package racingcar.io;

import java.util.HashMap;

public class ErrorHandler {
    public static void checkLength(String userInput) {
        if (userInput.length() > 5) {
            throw new IllegalArgumentException("Error! 입력값은 5이하여야 합니다");
        }
    }
    public static void checkUnique(String userInput, HashMap<String, Integer> playingStatus) {
        if (playingStatus.containsKey(userInput)) {
            throw new IllegalArgumentException("Error! 이미 같은 닉네임 플레이어 등록되어 있습니다!");
        }
    }
    public static void checkRound(String userInput) {
        if (!userInput.matches("-?\\d+")) {
            throw new IllegalArgumentException("Error! 입력값은 Integer 여야 합니다");
        }
        if (Integer.parseInt(userInput) <= 0 ){
            throw new IllegalArgumentException("Error! 입력값은 양수여야 합니다.");
        }
    }
}
