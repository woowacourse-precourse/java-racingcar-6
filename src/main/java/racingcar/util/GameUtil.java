package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class GameUtil {
    public static final int MAX_PLAYER_NAME_LENGTH = 5;

    public static final int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static final void isIllegalPlayerInfo(String[] str) {
        for (int i = 0; i < str.length; i++) {
            if (str[i].contains(" ") || str[i].length() > MAX_PLAYER_NAME_LENGTH || str[i].length() == 0) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static final void isIllegalRoundInfo(String str) {
        try {
            int temp = Integer.parseInt(str);
            if (temp <= 0) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
