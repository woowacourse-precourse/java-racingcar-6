package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Player {

    public List<String> inputCarNames(){
        String carNames = Console.readLine();
        List<String> names = Arrays.stream(carNames.split(",")).toList();
        return names;
    }
}
