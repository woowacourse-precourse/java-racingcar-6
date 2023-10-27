package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class RacingCar {
    public void playGame() {
        List<String> carNames = getCarNames();
//        System.out.println(carNames);
    }

    private List<String> getCarNames() {
        String names = Console.readLine();
        String[] nameArr = names.split(",");
        return Arrays.asList((nameArr));
    }
}
