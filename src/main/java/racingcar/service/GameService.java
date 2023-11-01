package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.domain.Car;
import racingcar.view.InputView;

public class GameService {
    private Map<Car, List<Integer>> positionHistory = new HashMap<>();

    Map<Car, List<Integer>> getPositionHistory() {
        return positionHistory;
    }

    private String getCarNamesByUserInput() {
        InputView.requestCarNamesMessage();
        String input = Console.readLine();
        
    }
}
