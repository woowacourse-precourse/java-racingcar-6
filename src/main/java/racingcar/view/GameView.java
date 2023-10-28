package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.utility.InputDataExceptionHandler;

public class GameView {
    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String playerCarNames = Console.readLine();
        List<String> carNames = Arrays.asList(playerCarNames.split(","));

        InputDataExceptionHandler.validateCarNames(carNames);

        return carNames;
    }
}
