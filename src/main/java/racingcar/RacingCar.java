package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class RacingCar {
    public void playGame() {
        List<String> carNames = getCarNames();
        int num = getNumber();
        System.out.println(carNames);
        System.out.println(num);
    }

    private List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        String[] nameArr = names.split(",");
        return Arrays.asList((nameArr));
    }

    private int getNumber() throws IllegalArgumentException {
        System.out.println("시도할 회수는 몇회인가요?");
        String numStr = Console.readLine();
        return Integer.parseInt(numStr);
    }
}
