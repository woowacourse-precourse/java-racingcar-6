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

    public static void nameErrorCheck(String[] carNames){
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }
}
