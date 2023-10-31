package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputManager {
    public List<String> getCarNames() {
        String input = Console.readLine();
        String[] splited = input.split(",");
        return List.of(splited);
    }

    public int getRaceCount() {
        // TODO: 경주 횟수 입력받기
        return 1;
    }
}
