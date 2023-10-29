package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameProcess {
    public void startGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();
        List<String> carList = parseCarName(carName);

        System.out.println(carList);
    }

    // 쉼표(,)를 기준으로 입력된 자동차 이름 분해 후 List에 저장
    public List<String> parseCarName(String input) {
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }
}
