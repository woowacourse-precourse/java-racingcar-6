package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class InputManager {
    private final InputValidator validator = new InputValidator();

    public void startGame() {
        getCarNames();
        getRaceRounds();
    }

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = new ArrayList<>(Arrays.asList(Console.readLine().split(",")));
        if (validator.isSingleCarInput(carNames)) {
            throw new IllegalArgumentException();
        }
        validator.checkForWhitespace(carNames);
        return carNames;
    }

    public int getRaceRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }
}
