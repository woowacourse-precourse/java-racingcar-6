package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class InputManager {
    public void startGame() {
        getCarNames();
    }

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return new ArrayList<>(Arrays.asList(Console.readLine().split(",")));
    }
}
