package racingcar.model;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class User {
    public Integer numberOfAttempt;
    public ArrayList<String> carNames;

    //    1. 시도할 횟수 얻기
    public Integer getNumberOfAttempt() {
        String inputNumber = Console.readLine();
        numberOfAttempt = Integer.parseInt(inputNumber);
        return numberOfAttempt;
    }

    //    2. 차량 이름 입력하기
    public ArrayList<String> getGetCarNames() {
        String inputNames = Console.readLine();
        String[] splitNames = inputNames.split(",");

        for (String name : splitNames) {
            carNames.add(name);
        }

        return carNames;
    }
}
