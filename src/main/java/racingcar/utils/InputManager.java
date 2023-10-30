package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {

    public int Number(){
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

    public String Cars() {
        String cars = Console.readLine();
        String[] carNames = cars.split(",");
        for (String name:
             carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
        return cars;
    }

    //todo validator 분리

}
