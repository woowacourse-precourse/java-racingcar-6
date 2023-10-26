package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

public class User {
    public String[] splitCarsName() {
        String carsNameString = Console.readLine();
        String[] carsNameArray = carsNameString.split(",");
        return carsNameArray;
    }

    // 테스트를 위한 코드
    public String[] splitCarsName(String input) {
        String[] carsNameArray = input.split(",");
        return carsNameArray;
    }
}