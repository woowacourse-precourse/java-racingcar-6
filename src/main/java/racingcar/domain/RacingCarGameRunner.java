package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGameRunner {
    private final String GAME_START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String NUMBER_OF_ROUND_MESSAGE = "시도할 회수는 몇회인가요?";

    private List<Car> cars;

    public void run() {
        String carNameInput = getPlayerInput(GAME_START_MESSAGE);

    }

    private String getPlayerInput(String message) {
        System.out.println(message);
        return Console.readLine();
    }

}
