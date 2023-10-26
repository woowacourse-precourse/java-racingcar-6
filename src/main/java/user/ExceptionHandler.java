package user;

import java.util.*;

public class ExceptionHandler {
    // player의 이름 길이 조절 상수
    private static final int maxValidLength = 5;

    public static boolean isValidLength(String playerName) {
        return !playerName.isEmpty() && playerName.length() <= maxValidLength;
    }

    // 대문지, 소문자, 숫자 허용 || 특수문자, 공백 불허
    public static boolean isValidPlayerName(String playName) {
        return playName.matches("^[a-zA-Z0-9]+$");
    }

    // 중복 이름 불허
    public static boolean isNameAlreadyExists(List<String> playerArray) {
        for (String player : playerArray) {
            if (playerArray.contains(player)) return true;
        }
        return false;
    }

    public static void raiseException(List<String> playerArray) {
        for (String playerName : playerArray) {
            if (!isValidPlayerName(playerName)) {
                throw new IllegalArgumentException("공백 또는 특수문자는 이름에 사용하실 수 없습니다.");
            }
            if (!isValidLength(playerName)) {
                throw new IllegalArgumentException("이름의 길이는 최소 1자에서 최대 5자까지 가능합니다.");
            }
        }
        if (isNameAlreadyExists(playerArray)) {
            throw new IllegalArgumentException("이미 존재하는 이름입니다.");
        }

    }
}
