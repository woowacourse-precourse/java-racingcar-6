package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class CustomException {


    public void checkInputValidLength(List<String> players) {
        for (String check : players) {
            if (check.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public void checkInputDuplication(List<String> players) {
        Set<String> playerSet = new HashSet<>(players);
        if (players.size() != playerSet.size()) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

    public int convertStrToInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력된 문자열이 정수 형식이 아닙니다.");
        }
    }
}
