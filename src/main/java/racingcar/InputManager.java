package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class InputManager {
    private final InputValidator validator = new InputValidator();

    public void startGame() {
        List<String> carNames = getCarNames();
        int raceRound = getRaceRound();
        GameLogic gameLogic = new GameLogic();
        gameLogic.runGame(carNames, raceRound);
    }

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = new ArrayList<>(Arrays.asList(Console.readLine().split(",")));
        if (validator.isSingleCarInput(carNames)) {
            throw new IllegalArgumentException();
        }
        validator.checkForWhitespace(carNames);
        validator.checkNameLength(carNames);
        validator.checkForDuplicates(carNames);
        return carNames;
    }

    public int getRaceRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        int raceRound = Integer.parseInt(Console.readLine());
        validator.validateraceRound(raceRound);
        return raceRound;
    }
}
