package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Player {

    public Player() {
    }

    public String inputCarName() {
        String carName = Console.readLine();
        checkInputFormat(carName);
        return carName;
    }

    public void checkInputFormat(String carName) {
        int lastStringIndex = carName.length() - 1;

        for (int i = 0; i < lastStringIndex; i++) {
            if (carName.charAt(i) == ',' && carName.charAt(i + 1) == ',') {
                throw new IllegalArgumentException("쉼표 다음에 쉼표가 나온 잘못된 입력입니다.");
            }
        }

        if (carName.charAt(lastStringIndex) == ',') {
            throw new IllegalArgumentException("쉼표가 마지막에 나온 잘못된 입력입니다.");
        }
    }
}
