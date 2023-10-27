package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Player {

    public Player() {
    }

    public String inputCarName() {
        String carName = Console.readLine();
        checkCarNameFormat(carName);
        return carName;
    }

    public void checkCarNameFormat(String carName) {
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

    public int inputMovingCount() {
        String movingCount = Console.readLine();
        checkMovingCountFormat(movingCount);
        return Integer.parseInt(movingCount);
    }

    public void checkMovingCountFormat(String movingCount) {
        for (int i = 0; i < movingCount.length(); i++) {
            char oneCharacter = movingCount.charAt(i);
            if (Character.isDigit(oneCharacter) == false) {
                throw new IllegalArgumentException("이동 횟수에 숫자가 아닌 다른 것이 입력된 잘못된 입력입니다.");
            }
        }
    }
}
