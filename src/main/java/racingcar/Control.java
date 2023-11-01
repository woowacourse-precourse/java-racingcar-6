package racingcar;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Control {
    public static String[] inputName() {
        String userInputCarName = Console.readLine();
        String[] carNames = userInputCarName.split(",");

        nameErrorCheck(carNames);

        return carNames;
    }

    public static int inputCount() {
        String userInputCount = Console.readLine();
        int count = Integer.parseInt(userInputCount);

        countErrorCheck(count);

        return count;
    }

    public static void nameErrorCheck(String[] carNames){
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public static void countErrorCheck(int count){
        if (count < 1) {
            throw new IllegalArgumentException("시도 횟수는 양수인 정수만 입력이 가능합니다.");
        }
    }
}
