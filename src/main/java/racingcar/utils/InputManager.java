package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {

    public int number(){
        String numString = Console.readLine();
        Integer number = null;
        try {
             number = Integer.parseInt(numString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 수 입력");
        }
        return number;
    }
    //todo validator 분리

    public String cars() {
        String carStr = Console.readLine();
        String[] carNames = carStr.split(",");
        for (String name:
             carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
        return carStr;
    }

    //todo validator 분리

}
